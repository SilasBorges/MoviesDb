package com.companysilas.core.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.companysilas.core.domain.model.DataReview
import com.companysilas.core.repository.ReviewsRepository
import com.companysilas.core.usecase.base.PagingUseCase
import kotlinx.coroutines.flow.Flow

interface ReviewsUseCase {

    operator fun invoke(params: Params): Flow<PagingData<DataReview>>

    data class Params(
        val id: Int
    )
}
class ReviewsUseCaseImpl(
    private val repository: ReviewsRepository
): PagingUseCase<ReviewsUseCase.Params, DataReview>(), ReviewsUseCase {
    override fun createFlowObservable(
        params: ReviewsUseCase.Params
    ): Flow<PagingData<DataReview>> {
        val pagingSource = repository.getReviews(params.id)
        return Pager(config = getPagerConfig()) {
            pagingSource
        }.flow
    }

    private fun getPagerConfig() = PagingConfig(
        pageSize = 20
    )
}