package com.companySilas.moviesdb.presentation.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.companySilas.moviesdb.databinding.ActivityMainBinding
import com.companySilas.moviesdb.presentation.detail.DetailsActivity
import com.companySilas.moviesdb.presentation.home.toprated.nowPlaying.NowPlayingAdapter
import com.companySilas.moviesdb.presentation.home.popular.PopularAdapter
import com.companySilas.moviesdb.presentation.home.toprated.TopRatedAdapter
import com.companySilas.moviesdb.presentation.home.upComing.UpComingAdapter
import com.facebook.shimmer.ShimmerFrameLayout
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: HomeViewModel by viewModel()

    private val nowPlayingAdapter by lazy {
        NowPlayingAdapter{
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("id", it.id)
            startActivity(intent)
        }
    }

    private val upComingAdapter by lazy {
        UpComingAdapter{
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("id", it.id)
            startActivity(intent)
        }
    }

    private val popularAdapter by lazy {
        PopularAdapter{
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("id", it.id)
            startActivity(intent)
        }
    }

    private val topRatedAdapter by lazy {
        TopRatedAdapter{
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("id", it.id)
            startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        initNowPlaying()
        initUpcoming()
        initPopular()
        initTopRated()
        observeInitialLoadState()
        setContentView(binding.root)
    }

    private fun initNowPlaying() {
        lifecycleScope.launch {
            viewModel.nowPlayingPagingData().collect() { pagingData ->
                binding.includeViewHomeSuccessState.rvExhibition.adapter = nowPlayingAdapter
                nowPlayingAdapter.submitData(pagingData)
            }
        }
    }

    private fun initUpcoming() {
        lifecycleScope.launch {
            viewModel.upComingPagingData().collect() { pagingData ->
                binding.includeViewHomeSuccessState.rvBrief.adapter = upComingAdapter
                upComingAdapter.submitData(pagingData)
            }
        }
    }

    private fun initPopular() {
        lifecycleScope.launch {
            viewModel.popularPagingData().collect() { pagingData ->
                binding.includeViewHomeSuccessState.rvMorePopular.adapter = popularAdapter
                popularAdapter.submitData(pagingData)
            }
        }
    }

    private fun initTopRated() {
        lifecycleScope.launch {
            viewModel.topRatedPagingData().collect() { pagingData ->
                binding.includeViewHomeSuccessState.rvBestRated.adapter = topRatedAdapter
                topRatedAdapter.submitData(pagingData)
            }
        }
    }

    private fun observeInitialLoadState() {
        lifecycleScope.launch {
            nowPlayingAdapter.loadStateFlow.collectLatest { loadState ->
                binding.flipperMovie.displayedChild = when (loadState.refresh) {
                    is LoadState.Loading -> {
                        setShimmerVisibility(true)
                        FLIPPER_CHILD_LOADING
                    }
                    is LoadState.NotLoading -> {
                        setShimmerVisibility(false)
                        FLIPPER_CHILD_CHARACTERS
                    } is LoadState.Error -> {
                        setShimmerVisibility(false)
                        binding.includeViewHomeErrorState.buttonRetry.setOnClickListener {
                            nowPlayingAdapter.retry()
                            upComingAdapter.retry()
                            popularAdapter.retry()
                            topRatedAdapter.retry()
                        }
                        FLIPPER_CHILD_ERROR
                    }
                }
            }
        }
    }

    private fun setShimmerVisibility(visibility: Boolean) {
        binding.includeViewHomeLoadingState.loadingMovie.run {
            isVisible = visibility
            if(visibility) {
                startShimmer()
            } else stopShimmer()
        }
    }

    companion object {
        private const val FLIPPER_CHILD_LOADING = 0
        private const val FLIPPER_CHILD_CHARACTERS = 1
        private const val FLIPPER_CHILD_ERROR = 2
    }
}