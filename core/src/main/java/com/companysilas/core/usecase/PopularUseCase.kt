package com.companysilas.core.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.companysilas.core.domain.response.DataNowPlaying
import com.companysilas.core.repository.PopularRepository
import com.companysilas.core.usecase.base.PagingUseCase
import kotlinx.coroutines.flow.Flow

interface PopularUseCase {

    operator fun invoke(params: Params): Flow<PagingData<DataNowPlaying>>

    object Params
}
class PopularUseCaseImpl(
    private val repository: PopularRepository
): PagingUseCase<PopularUseCase.Params, DataNowPlaying>(), PopularUseCase {
    override fun createFlowObservable(params: PopularUseCase.Params): Flow<PagingData<DataNowPlaying>> {
        val pagingSource = repository.getPopular()
        return Pager(config = getPagerConfig()) {
            pagingSource
        }.flow
    }

    private fun getPagerConfig() = PagingConfig(
        pageSize = 20
    )
}