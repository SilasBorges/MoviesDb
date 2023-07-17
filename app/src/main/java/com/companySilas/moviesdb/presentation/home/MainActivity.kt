package com.companySilas.moviesdb.presentation.home

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.companySilas.moviesdb.databinding.ActivityMainBinding
import com.companySilas.moviesdb.presentation.detail.DetailsActivity
import com.companySilas.moviesdb.presentation.home.toprated.nowPlaying.NowPlayingAdapter
import com.companySilas.moviesdb.presentation.home.popular.PopularAdapter
import com.companySilas.moviesdb.presentation.home.toprated.TopRatedAdapter
import com.companySilas.moviesdb.presentation.home.upComing.UpComingAdapter
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
        setContentView(binding.root)
    }

    private fun initNowPlaying() {
        lifecycleScope.launch {
            viewModel.nowPlayingPagingData().collect() { pagingData ->
                binding.rvExhibition.adapter = nowPlayingAdapter
                nowPlayingAdapter.submitData(pagingData)
            }
        }
    }

    private fun initUpcoming() {
        lifecycleScope.launch {
            viewModel.upComingPagingData().collect() { pagingData ->
                binding.rvBrief.adapter = upComingAdapter
                upComingAdapter.submitData(pagingData)
            }
        }
    }

    private fun initPopular() {
        lifecycleScope.launch {
            viewModel.popularPagingData().collect() { pagingData ->
                binding.rvMorePopular.adapter = popularAdapter
                popularAdapter.submitData(pagingData)
            }
        }
    }

    private fun initTopRated() {
        lifecycleScope.launch {
            viewModel.topRatedPagingData().collect() { pagingData ->
                binding.rvBestRated.adapter = topRatedAdapter
                topRatedAdapter.submitData(pagingData)
            }
        }
    }
}