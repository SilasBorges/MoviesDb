package com.companySilas.moviesdb.presentation.detail

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.companySilas.moviesdb.databinding.ItemCommentsBinding
import com.companysilas.core.domain.model.DataReview

class ReviewsViewHolder(
    private val binding: ItemCommentsBinding,
    private val clickListener: (DataReview) -> Unit,
    private val context: Context
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data: DataReview) {


        binding.textName.text = data.author
        binding.textDescComments.text = data.content



    }

    companion object {
        fun create(
            parent: ViewGroup,
            clickListener: (DataReview) -> Unit
        ): ReviewsViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val itemBinding = ItemCommentsBinding.inflate(inflater, parent, false)
            return ReviewsViewHolder(itemBinding, clickListener, parent.context)
        }
    }
}