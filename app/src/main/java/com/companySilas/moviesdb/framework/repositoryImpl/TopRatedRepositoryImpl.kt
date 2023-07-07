package com.companySilas.moviesdb.framework.repositoryImpl

import androidx.paging.PagingSource
import com.companySilas.moviesdb.framework.paging.TopRatedPagingSource
import com.companySilas.moviesdb.framework.service.ApiService
import com.companysilas.core.domain.model.DataNowPlaying
import com.companysilas.core.repository.TopRatedRepository

class TopRatedRepositoryImpl(
    private val apiService: ApiService
) : TopRatedRepository {
    override fun getTopRated(): PagingSource<Int, DataNowPlaying> {
        return TopRatedPagingSource(apiService)
    }
}