package com.companysilas.core.usecase

import com.companysilas.core.domain.response.DetailResponse
import com.companysilas.core.repository.DetailRepository
import com.companysilas.core.usecase.base.CoroutinesDispatchers
import com.companysilas.core.usecase.base.ResultStatus
import com.companysilas.core.usecase.base.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

interface DetailUseCase {

    operator fun invoke(params: Params): Flow<ResultStatus<DetailResponse>>

    data class Params (
        val id: Int
    )
}
class DetailsUseCaseImpl(
    private val repository: DetailRepository,
    private val dispatchers: CoroutinesDispatchers
) : UseCase<DetailUseCase.Params, DetailResponse>(), DetailUseCase {
    override suspend fun doWork(params: DetailUseCase.Params): ResultStatus<DetailResponse> {
        return withContext(dispatchers.io()) {
            val result = repository.detail(params.id)
            ResultStatus.Success(result)
        }
    }
}