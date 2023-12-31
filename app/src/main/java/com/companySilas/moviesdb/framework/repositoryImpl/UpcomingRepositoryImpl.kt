package com.companySilas.moviesdb.framework.repositoryImpl

import androidx.paging.PagingSource
import com.companySilas.moviesdb.framework.paging.UpcomingPagingSource
import com.companySilas.moviesdb.framework.service.ApiService
import com.companysilas.core.domain.response.DataNowPlaying
import com.companysilas.core.repository.UpcomingRepository

class UpcomingRepositoryImpl(
    private val apiService: ApiService
) : UpcomingRepository {
    override fun getUpcoming(): PagingSource<Int, DataNowPlaying> {
        return UpcomingPagingSource(apiService)
    }
}