package com.companySilas.moviesdb.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.companysilas.core.domain.response.DataNowPlaying
import com.companysilas.core.usecase.NowPlayingUseCase
import com.companysilas.core.usecase.PopularUseCase
import com.companysilas.core.usecase.TopRatedUseCase
import com.companysilas.core.usecase.UpcomingUseCase
import kotlinx.coroutines.flow.Flow

class HomeViewModel(
    private val nowPlayingUseCase: NowPlayingUseCase,
    private val upcomingUseCase: UpcomingUseCase,
    private val popularUseCase: PopularUseCase,
    private val topRatedUseCase: TopRatedUseCase
): ViewModel() {

    fun nowPlayingPagingData(): Flow<PagingData<DataNowPlaying>> {
        return nowPlayingUseCase(
            NowPlayingUseCase.Params
        ).cachedIn(viewModelScope)
    }

    fun upComingPagingData(): Flow<PagingData<DataNowPlaying>> {
        return upcomingUseCase(
            UpcomingUseCase.Params
        ).cachedIn(viewModelScope)
    }

    fun popularPagingData(): Flow<PagingData<DataNowPlaying>> {
        return popularUseCase(
            PopularUseCase.Params
        ).cachedIn(viewModelScope)
    }

    fun topRatedPagingData(): Flow<PagingData<DataNowPlaying>> {
        return topRatedUseCase(
            TopRatedUseCase.Params
        ).cachedIn(viewModelScope)
    }
}