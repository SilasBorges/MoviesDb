package com.companysilas.core.repository

import androidx.paging.PagingSource
import com.companysilas.core.domain.response.DataNowPlaying

interface UpcomingRepository {

    fun getUpcoming(): PagingSource<Int, DataNowPlaying>
}