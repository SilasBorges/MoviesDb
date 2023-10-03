package com.companySilas.moviesdb.presentation.detail

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.transition.TransitionInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.companySilas.moviesdb.databinding.ActivityDetailsBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.DecimalFormat
import java.time.Duration

class DetailsActivity : AppCompatActivity() {

    private var time = NUMBER_0

    private lateinit var binding: ActivityDetailsBinding

    private val viewModel: DetailViewModel by viewModel()

    private val reviewsAdapter by lazy {
        ReviewsAdapter()
    }

    private val movieID by lazy {
        intent.getIntExtra(ID, NUMBER_0)
    }

    private fun init() {
        onClick()
        observe()
        viewModel.loading(movieID)
        initReviews(movieID)
        initMovieSimilar(movieID)
        setSharedElementTransitionOnEnter()
    }

    private val movieSimilarAdapter by lazy {
        MovieSimilarAdapter {
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra(ID, it.id)
            startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        init()
        setContentView(binding.root)
    }

    private fun onClick() {
        binding.includeSuccess.imageBack.setOnClickListener { finish() }
    }

    @SuppressLint("SetTextI18n")
    private fun observe() {
        viewModel.state.observe(this) { uiState ->
            binding.flipperDetail.displayedChild = when (uiState) {

                DetailViewModel.State.Loading -> {
                    FLIPPER_CHILD_POSITION_LOADING
                }

                is DetailViewModel.State.Success -> {
                    binding.includeSuccess.textTitle.text = uiState.data.title
                    Glide
                        .with(this)
                        .load(String.format(URL_IMAGE, uiState.data.backdropPath))
                        .fitCenter()
                        .into(binding.includeSuccess.imageBanner)

                    Glide
                        .with(this)
                        .load(String.format(URL_IMAGE, uiState.data.postPath))
                        .fitCenter()
                        .into(binding.includeSuccess.imagePoster)

                    binding.includeSuccess.textDescSynopsys.text = uiState.data.overview

                    val decimalFormat = DecimalFormat(DECIMAL_FORMAT)
                    val formattedNumber = decimalFormat.format(uiState.data.voteAverage)

                    binding.includeSuccess.textVote.text = formattedNumber

                    time = uiState.data.runtime

                    val duration = Duration.ofMinutes(time.toLong())

                    val hours = duration.toHours()
                    val minutes = duration.toMinutes() % SECONDS

                    binding.includeSuccess.durationTime.text =
                        hours.toString() + FORMAT_HOURS + minutes.toString() + FORMAT_MINUTES

                    FLIPPER_CHILD_POSITION_DETAIL

                }

                DetailViewModel.State.Error -> {
                    binding.includeError.buttonRetry.setOnClickListener {
                        viewModel.loading(movieID)
                        initReviews(movieID)
                        initMovieSimilar(movieID)
                    }

                    FLIPPER_CHILD_POSITION_ERROR
                }
            }
        }
    }

    private fun initReviews(id: Int) {
        lifecycleScope.launch {
            viewModel.reviewsPagingData(id).collect { pagingData ->
                binding.includeSuccess.rvComments.adapter = reviewsAdapter
                reviewsAdapter.submitData(pagingData)
            }
        }
    }

    private fun initMovieSimilar(id: Int) {
        lifecycleScope.launch {
            viewModel.movieSimilar(id).collect() { pagingData ->
                binding.includeSuccess.rvMoreLike.adapter = movieSimilarAdapter
                movieSimilarAdapter.submitData(pagingData)
            }
        }
    }

    private fun setSharedElementTransitionOnEnter() {
        val transition = TransitionInflater.from(this)
            .inflateTransition(android.R.transition.move)
        window.sharedElementEnterTransition = transition
    }

    companion object {
        const val SECONDS = 60

        private const val FLIPPER_CHILD_POSITION_LOADING = 0
        private const val FLIPPER_CHILD_POSITION_DETAIL = 1
        private const val FLIPPER_CHILD_POSITION_ERROR = 2

        private const val NUMBER_0 = 0
        private const val ID = "id"
        private const val DECIMAL_FORMAT = "#.#"
        private const val FORMAT_HOURS = "hora(s) "
        private const val FORMAT_MINUTES = " minuto(s)"

        private const val URL_IMAGE = "https://image.tmdb.org/t/p/w500%s"
    }
}
