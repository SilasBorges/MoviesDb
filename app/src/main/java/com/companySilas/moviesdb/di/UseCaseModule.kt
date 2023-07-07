package com.companySilas.moviesdb.di

import com.companysilas.core.usecase.NowPlayingUseCase
import com.companysilas.core.usecase.NowPlayingUseCaseImpl
import com.companysilas.core.usecase.UpComingUseCaseImpl
import com.companysilas.core.usecase.UpcomingUseCase
import org.koin.dsl.module

val useCase = module {

    single<NowPlayingUseCase> { NowPlayingUseCaseImpl(get())}

    single<UpcomingUseCase> { UpComingUseCaseImpl(get())}
}