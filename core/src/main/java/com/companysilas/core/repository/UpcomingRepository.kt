package com.companysilas.core.repository

import androidx.paging.PagingSource
import com.companysilas.core.domain.model.DataNowPlaying

interface UpcomingRepository {

    fun getUpcoming(): PagingSource<Int, DataNowPlaying>
}