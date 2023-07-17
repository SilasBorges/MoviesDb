package com.companySilas.moviesdb.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.companySilas.moviesdb.util.watchStatus
import com.companysilas.core.domain.model.DataNowPlaying
import com.companysilas.core.domain.model.DataReview
import com.companysilas.core.domain.response.DetailResponse
import com.companysilas.core.repository.DetailRepository
import com.companysilas.core.usecase.DetailUseCase
import com.companysilas.core.usecase.MovieSimilarUseCase
import com.companysilas.core.usecase.ReviewsUseCase
import com.companysilas.core.usecase.base.CoroutinesDispatchers
import kotlinx.coroutines.flow.Flow

class DetailViewModel(
    private val detailUseCase: DetailUseCase,
    private val reviewsUseCase: ReviewsUseCase,
    private val movieSimilarUseCase: MovieSimilarUseCase,
    private val dispatchers: CoroutinesDispatchers
): ViewModel() {

    fun reviewsPagingData(id: Int): Flow<PagingData<DataReview>> {
        return reviewsUseCase(
            ReviewsUseCase.Params(id)
        ).cachedIn(viewModelScope)
    }

    fun movieSimilar(id: Int): Flow<PagingData<DataNowPlaying>> {
        return movieSimilarUseCase(
            MovieSimilarUseCase.Params(id)
        ).cachedIn(viewModelScope)
    }

    private val action = MutableLiveData<Action>()
    val state: LiveData<State> = action.switchMap {
        liveData(dispatchers.main()) {
            when(it) {
                is Action.Load -> {
                    detailUseCase.invoke(DetailUseCase.Params(it.id)).watchStatus(
                        loading = {
                            emit(State.Loading)
                        },
                        success = {
                            emit(State.Success(it))
                        },
                        error = {
                            emit(State.Error)
                        }
                    )
                }
            }
        }
    }

    sealed class Action {
        data class Load(
            val id: Int
        ): Action()
    }

    sealed class State {
        object Loading: State()
        data class Success(val data: DetailResponse): State()
        object Error: State()
    }

    fun loading(id: Int) {
        action.value = Action.Load(id)
    }
}