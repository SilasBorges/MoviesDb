package com.companySilas.moviesdb.presentation.detail

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.companySilas.moviesdb.databinding.ActivityDetailsBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.DecimalFormat
import java.time.Duration

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    private var time = 0

    private val viewModel: DetailViewModel by viewModel()

    private val reviewsAdapter by lazy {
        ReviewsAdapter{}
    }

    private val movieSimilarAdapter by lazy {
        MovieSimilarAdapter{
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("id", it.id)
            startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onClick()
        observe()
        val id = intent.getIntExtra("id", 0)
        viewModel.loading(id)
        initReviews(id)
        initMovieSimilar(id)
    }

    @SuppressLint("SetTextI18n")
    private fun observe() {
        viewModel.state.observe(this) { uiState ->
            when(uiState) {
                DetailViewModel.State.Loading -> {

                }
                is DetailViewModel.State.Success -> {
                    binding.textTitle.text = uiState.data.title
                    Glide
                        .with(this)
                        .load("https://image.tmdb.org/t/p/w500${uiState.data.backdropPath}")
                        .fitCenter()
                        .into(binding.imageBanner)

                    Glide
                        .with(this)
                        .load("https://image.tmdb.org/t/p/w500${uiState.data.postPath}")
                        .fitCenter()
                        .into(binding.imagePoster)

                    binding.textDescSynopsys.text = uiState.data.overview

                    val decimalFormat=  DecimalFormat("#.#")
                    val formattedNumber = decimalFormat.format(uiState.data.voteAverage)

                    binding.textVote.text = formattedNumber

                    time = uiState.data.runtime

                    val duration = Duration.ofMinutes(time.toLong())

                    val hours = duration.toHours()
                    val minutes = duration.toMinutes() % SECONDS

                    binding.durationTime.text =
                        hours.toString() + "hora(s) " + minutes.toString() + " minuto(s)"


                }
                DetailViewModel.State.Error -> {

                }
            }
        }
    }

    private fun initReviews(id: Int) {
        lifecycleScope.launch {
            viewModel.reviewsPagingData(id).collect { pagingData ->
                binding.rvComments.adapter = reviewsAdapter
                reviewsAdapter.submitData(pagingData)
            }
        }
    }

    private fun initMovieSimilar(id: Int) {
        lifecycleScope.launch {
            viewModel.movieSimilar(id).collect() { pagingData ->
                binding.rvMoreLike.adapter = movieSimilarAdapter
                movieSimilarAdapter.submitData(pagingData)
            }
        }
    }

    private fun onClick() {
        binding.imageBack.setOnClickListener { finish() }
    }

    companion object {
        const val SECONDS = 60
    }
}