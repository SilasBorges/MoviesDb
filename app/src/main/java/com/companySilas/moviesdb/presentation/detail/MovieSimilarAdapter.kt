package com.companySilas.moviesdb.presentation.detail

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.companySilas.moviesdb.presentation.home.toprated.nowPlaying.NowPlayingViewHolder
import com.companysilas.core.domain.response.DataNowPlaying

class MovieSimilarAdapter(
    private val adapterOnClick: (DataNowPlaying) -> Unit
) : PagingDataAdapter<DataNowPlaying, NowPlayingViewHolder>(diffCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NowPlayingViewHolder {
        return NowPlayingViewHolder.create(
            parent,
            adapterOnClick
        )
    }

    override fun onBindViewHolder(holder: NowPlayingViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<DataNowPlaying>() {
            override fun areItemsTheSame(
                oldItem: DataNowPlaying,
                newItem: DataNowPlaying
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: DataNowPlaying,
                newItem: DataNowPlaying
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}