package com.companysilas.core.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.companysilas.core.domain.model.DataNowPlaying
import com.companysilas.core.repository.TopRatedRepository
import com.companysilas.core.usecase.base.PagingUseCase
import kotlinx.coroutines.flow.Flow

interface TopRatedUseCase {

    operator fun invoke(params: Params): Flow<PagingData<DataNowPlaying>>

    object Params
}
class TopRatedUseCaseImpl(
    private val repository: TopRatedRepository
): PagingUseCase<TopRatedUseCase.Params, DataNowPlaying>(), TopRatedUseCase {
    override fun createFlowObservable(params: TopRatedUseCase.Params): Flow<PagingData<DataNowPlaying>> {
        val pagingSource = repository.getTopRated()
        return Pager(config = getPagerConfig()) {
            pagingSource
        }.flow
    }

    private fun getPagerConfig() = PagingConfig(
        pageSize = 20
    )
}