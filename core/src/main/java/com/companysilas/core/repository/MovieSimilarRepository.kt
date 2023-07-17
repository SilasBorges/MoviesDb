package com.companysilas.core.repository

import androidx.paging.PagingSource
import com.companysilas.core.domain.model.DataNowPlaying

interface MovieSimilarRepository {

    fun getMovieSimilar(id: Int): PagingSource<Int, DataNowPlaying>
}