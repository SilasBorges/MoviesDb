package com.companySilas.moviesdb.framework.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.companySilas.moviesdb.framework.service.ApiService
import com.companysilas.core.domain.model.DataNowPlaying

class PopularPagingSource(
    private val apiService: ApiService
) : PagingSource<Int, DataNowPlaying>() {

    @Suppress("TooGenericExceptionCaught")
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DataNowPlaying> {
        return try {
            val page = params.key ?: 1

            val queries = hashMapOf(
                "language" to LANGUAGE,
                "page" to page.toString(),
                "region" to REGION
            )

            val paging = apiService.popular(queries)

            val responseOffset = paging.page
            val totalMarket = paging.totalPages

            LoadResult.Page(
                data = paging.results,
                prevKey = null,
                nextKey = if (responseOffset < totalMarket) {
                    responseOffset + LIMIT
                } else null
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, DataNowPlaying>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(LIMIT) ?: anchorPage?.nextKey?.minus(
                LIMIT
            )
        }
    }

    companion object {
        private const val LIMIT = 20
        private const val LANGUAGE = "pt-BR"
        private const val REGION = "BR"
    }
}