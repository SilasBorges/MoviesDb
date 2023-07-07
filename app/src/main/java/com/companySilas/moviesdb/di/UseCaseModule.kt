package com.companySilas.moviesdb.di

import com.companysilas.core.usecase.NowPlayingUseCase
import com.companysilas.core.usecase.NowPlayingUseCaseImpl
import org.koin.dsl.module

val useCase = module {

    single<NowPlayingUseCase> { NowPlayingUseCaseImpl(get())}
}