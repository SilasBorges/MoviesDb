package com.companySilas.moviesdb.presentation.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.companySilas.moviesdb.databinding.ActivityMainBinding
import com.companySilas.moviesdb.presentation.home.nowPlaying.NowPlayingAdapter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: HomeViewModel by viewModel()

    private val nowPlayingAdapter by lazy {
        NowPlayingAdapter{}
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        initNowPlaying()
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
}