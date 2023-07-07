package com.companySilas.moviesdb.presentation.home.upComing

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.companySilas.moviesdb.presentation.home.nowPlaying.NowPlayingViewHolder
import com.companysilas.core.domain.model.DataNowPlaying

class UpComingAdapter(
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