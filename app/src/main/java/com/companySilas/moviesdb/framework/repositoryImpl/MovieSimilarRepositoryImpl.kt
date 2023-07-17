package com.companySilas.moviesdb.framework.repositoryImpl

import androidx.paging.PagingSource
import com.companySilas.moviesdb.framework.paging.MovieSimilarPagingSource
import com.companySilas.moviesdb.framework.service.ApiService
import com.companysilas.core.domain.model.DataNowPlaying
import com.companysilas.core.repository.MovieSimilarRepository

class MovieSimilarRepositoryImpl(
    private val apiService: ApiService
) : MovieSimilarRepository {
    override fun getMovieSimilar(id: Int): PagingSource<Int, DataNowPlaying> {
        return MovieSimilarPagingSource(apiService, id)
    }
}