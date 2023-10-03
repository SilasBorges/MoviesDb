package com.companySilas.moviesdb.framework.repositoryImpl

import androidx.paging.PagingSource
import com.companySilas.moviesdb.framework.paging.ReviewsPagingSource
import com.companySilas.moviesdb.framework.service.ApiService
import com.companysilas.core.domain.response.DataReview
import com.companysilas.core.repository.ReviewsRepository

class ReviewsRepositoryImpl(
    private val apiService: ApiService
) : ReviewsRepository {
    override fun getReviews(id: Int): PagingSource<Int, DataReview> {
        return ReviewsPagingSource(apiService, id)
    }
}