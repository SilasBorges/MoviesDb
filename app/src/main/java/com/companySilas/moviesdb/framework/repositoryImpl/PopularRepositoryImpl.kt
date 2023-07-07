package com.companySilas.moviesdb.framework.repositoryImpl

import androidx.paging.PagingSource
import com.companySilas.moviesdb.framework.paging.PopularPagingSource
import com.companySilas.moviesdb.framework.service.ApiService
import com.companysilas.core.domain.model.DataNowPlaying
import com.companysilas.core.repository.PopularRepository

class PopularRepositoryImpl(
    private val apiService: ApiService
) : PopularRepository {
    override fun getPopular(): PagingSource<Int, DataNowPlaying> {
        return PopularPagingSource(apiService)
    }
}