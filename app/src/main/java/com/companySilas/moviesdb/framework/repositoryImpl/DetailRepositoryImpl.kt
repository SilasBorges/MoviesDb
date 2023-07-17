package com.companySilas.moviesdb.framework.repositoryImpl

import com.companySilas.moviesdb.framework.service.ApiService
import com.companysilas.core.domain.response.DetailResponse
import com.companysilas.core.repository.DetailRepository

class DetailRepositoryImpl(
    private val apiService: ApiService
) : DetailRepository {
    override suspend fun detail(id: Int): DetailResponse {
        return apiService.details(id)
    }
}