package com.companySilas.moviesdb.presentation.home.toprated.nowPlaying

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.companySilas.moviesdb.R
import com.companySilas.moviesdb.databinding.ItemMovieBinding
import com.companysilas.core.domain.model.DataNowPlaying

class NowPlayingViewHolder(
    private val binding: ItemMovieBinding,
    private val clickListener: (DataNowPlaying) -> Unit,
    private val context: Context
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data: DataNowPlaying) {

        Glide
            .with(context)
            .load(String.format(URL_IMAGE, data.posterPath))
            .placeholder(R.drawable.background_imageload)
            .centerCrop()
            .into(binding.imageMovie)

        itemView.setOnClickListener {
            clickListener.invoke(data)
        }
    }

    companion object {

        const val URL_IMAGE = "https://image.tmdb.org/t/p/w500%s"

        fun create(
            parent: ViewGroup,
            clickListener: (DataNowPlaying) -> Unit
        ): NowPlayingViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val itemBinding = ItemMovieBinding.inflate(inflater, parent, false)
            return NowPlayingViewHolder(itemBinding, clickListener, parent.context)
        }
    }
}