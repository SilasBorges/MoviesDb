package com.companysilas.core.repository

import androidx.paging.PagingSource
import com.companysilas.core.domain.model.DataReview

interface ReviewsRepository {

    fun getReviews(id: Int): PagingSource<Int, DataReview>
}