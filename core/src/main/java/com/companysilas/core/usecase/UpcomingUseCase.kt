package com.companysilas.core.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.companysilas.core.domain.response.DataNowPlaying
import com.companysilas.core.repository.UpcomingRepository
import com.companysilas.core.usecase.base.PagingUseCase
import kotlinx.coroutines.flow.Flow

interface UpcomingUseCase {

    operator fun invoke(params: Params): Flow<PagingData<DataNowPlaying>>

    object Params

}
class UpComingUseCaseImpl(
    private val repository: UpcomingRepository
) : PagingUseCase<UpcomingUseCase.Params, DataNowPlaying>(), UpcomingUseCase {
    override fun createFlowObservable(params: UpcomingUseCase.Params): Flow<PagingData<DataNowPlaying>> {
        val pagingSource = repository.getUpcoming()
        return Pager(config = getPagerConfig()){
            pagingSource
        }.flow
    }

    private fun getPagerConfig() = PagingConfig(
        pageSize = 20
    )
}