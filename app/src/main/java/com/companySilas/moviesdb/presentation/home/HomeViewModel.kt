package com.companySilas.moviesdb.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.companysilas.core.domain.model.DataNowPlaying
import com.companysilas.core.usecase.NowPlayingUseCase
import kotlinx.coroutines.flow.Flow

class HomeViewModel(
    private val nowPlayingUseCase: NowPlayingUseCase
): ViewModel() {

    fun nowPlayingPagingData(): Flow<PagingData<DataNowPlaying>> {
        return nowPlayingUseCase(
            NowPlayingUseCase.Params
        ).cachedIn(viewModelScope)
    }
}