package com.companySilas.moviesdb.di

import com.companysilas.core.usecase.DetailUseCase
import com.companysilas.core.usecase.DetailsUseCaseImpl
import com.companysilas.core.usecase.MovieSimilarUseCase
import com.companysilas.core.usecase.MovieSimilarUseCaseImpl
import com.companysilas.core.usecase.NowPlayingUseCase
import com.companysilas.core.usecase.NowPlayingUseCaseImpl
import com.companysilas.core.usecase.PopularUseCase
import com.companysilas.core.usecase.PopularUseCaseImpl
import com.companysilas.core.usecase.ReviewsUseCase
import com.companysilas.core.usecase.ReviewsUseCaseImpl
import com.companysilas.core.usecase.TopRatedUseCase
import com.companysilas.core.usecase.TopRatedUseCaseImpl
import com.companysilas.core.usecase.UpComingUseCaseImpl
import com.companysilas.core.usecase.UpcomingUseCase
import org.koin.dsl.module

val useCase = module {

    single<NowPlayingUseCase> { NowPlayingUseCaseImpl(get())}

    single<UpcomingUseCase> { UpComingUseCaseImpl(get())}

    single<PopularUseCase> { PopularUseCaseImpl(get())}

    single<TopRatedUseCase> { TopRatedUseCaseImpl(get())}

    single<DetailUseCase> { DetailsUseCaseImpl(get(), get())}

    single<ReviewsUseCase> { ReviewsUseCaseImpl(get())}

    single<MovieSimilarUseCase> { MovieSimilarUseCaseImpl(get())}
}