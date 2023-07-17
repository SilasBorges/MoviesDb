package com.companysilas.core.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.companysilas.core.domain.model.DataNowPlaying
import com.companysilas.core.repository.MovieSimilarRepository
import com.companysilas.core.usecase.base.PagingUseCase
import kotlinx.coroutines.flow.Flow

interface MovieSimilarUseCase {

    operator fun invoke(params: Params): Flow<PagingData<DataNowPlaying>>

    data class Params(
        val id: Int
    )
}
class MovieSimilarUseCaseImpl(
    private val repository: MovieSimilarRepository
): PagingUseCase<MovieSimilarUseCase.Params, DataNowPlaying>(), MovieSimilarUseCase {
    override fun createFlowObservable(
        params: MovieSimilarUseCase.Params
    ): Flow<PagingData<DataNowPlaying>> {
        val pagingSource = repository.getMovieSimilar(params.id)
        return Pager(config = getPagerConfig()) {
            pagingSource
        }.flow
    }

    private fun getPagerConfig() = PagingConfig(
        pageSize = 20
    )
}