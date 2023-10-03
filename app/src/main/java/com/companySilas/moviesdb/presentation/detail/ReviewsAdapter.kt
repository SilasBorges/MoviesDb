package com.companySilas.moviesdb.presentation.detail

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.companysilas.core.domain.model.DataReview

class ReviewsAdapter : PagingDataAdapter<DataReview, ReviewsViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewsViewHolder {
        return ReviewsViewHolder.create(
            parent
        )
    }

    override fun onBindViewHolder(holder: ReviewsViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<DataReview>() {
            override fun areItemsTheSame(
                oldItem: DataReview,
                newItem: DataReview
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: DataReview,
                newItem: DataReview
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}