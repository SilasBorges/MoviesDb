package com.companysilas.core.repository

import androidx.paging.PagingSource
import com.companysilas.core.domain.response.DataNowPlaying

interface PopularRepository {

    fun getPopular(): PagingSource<Int, DataNowPlaying>

}