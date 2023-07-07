package com.companysilas.core.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.companysilas.core.domain.model.DataNowPlaying
import com.companysilas.core.repository.NowPlayingRepository
import com.companysilas.core.usecase.base.PagingUseCase
import kotlinx.coroutines.flow.Flow

interface NowPlayingUseCase {

    operator fun invoke(params: Params): Flow<PagingData<DataNowPlaying>>

    object Params
}
class NowPlayingUseCaseImpl(
    private val repository: NowPlayingRepository
) : PagingUseCase<NowPlayingUseCase.Params, DataNowPlaying>(), NowPlayingUseCase {
    override fun createFlowObservable(params: NowPlayingUseCase.Params): Flow<PagingData<DataNowPlaying>> {
        val pagingSource = repository.getNowPlaying()
        return Pager(config = getPagerConfig()) {
            pagingSource
        }.flow
    }

    private fun getPagerConfig() = PagingConfig(
        pageSize = 20
    )
}