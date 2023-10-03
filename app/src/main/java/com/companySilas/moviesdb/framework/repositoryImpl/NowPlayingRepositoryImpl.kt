package com.companySilas.moviesdb.framework.repositoryImpl

import androidx.paging.PagingSource
import com.companySilas.moviesdb.framework.paging.NowPlayingPagingSource
import com.companySilas.moviesdb.framework.service.ApiService
import com.companysilas.core.domain.response.DataNowPlaying
import com.companysilas.core.repository.NowPlayingRepository

class NowPlayingRepositoryImpl(
    private val apiService: ApiService
): NowPlayingRepository {
    override fun getNowPlaying(): PagingSource<Int, DataNowPlaying> {
        return NowPlayingPagingSource(apiService)
    }
}