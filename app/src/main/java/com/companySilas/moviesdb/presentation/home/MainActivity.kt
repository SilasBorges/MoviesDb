package com.companySilas.moviesdb.presentation.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.companySilas.moviesdb.databinding.ActivityMainBinding
import com.companySilas.moviesdb.presentation.home.nowPlaying.NowPlayingAdapter
import com.companySilas.moviesdb.presentation.home.upComing.UpComingAdapter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: HomeViewModel by viewModel()

    private val nowPlayingAdapter by lazy {
        NowPlayingAdapter{}
    }

    private val upComingAdapter by lazy {
        UpComingAdapter{}
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        initNowPlaying()
        initUpcoming()
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
}