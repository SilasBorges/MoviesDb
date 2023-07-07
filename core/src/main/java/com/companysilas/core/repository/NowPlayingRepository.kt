package com.companysilas.core.repository

import androidx.paging.PagingSource
import com.companysilas.core.domain.model.DataNowPlaying

interface NowPlayingRepository {

    fun getNowPlaying(): PagingSource<Int, DataNowPlaying>
}
