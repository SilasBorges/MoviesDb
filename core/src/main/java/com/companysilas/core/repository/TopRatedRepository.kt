package com.companysilas.core.repository

import androidx.paging.PagingSource
import com.companysilas.core.domain.model.DataNowPlaying

interface TopRatedRepository {

    fun getTopRated(): PagingSource<Int, DataNowPlaying>
}