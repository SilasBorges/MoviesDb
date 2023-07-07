package com.companysilas.core.repository

import androidx.paging.PagingSource
import com.companysilas.core.domain.model.DataNowPlaying

interface PopularRepository {

    fun getPopular(): PagingSource<Int, DataNowPlaying>

}