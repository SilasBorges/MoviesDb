package com.companySilas.moviesdb.di

import com.companySilas.moviesdb.framework.repositoryImpl.NowPlayingRepositoryImpl
import com.companySilas.moviesdb.framework.repositoryImpl.UpcomingRepositoryImpl
import com.companysilas.core.repository.NowPlayingRepository
import com.companysilas.core.repository.UpcomingRepository
import org.koin.dsl.module

val repositoryModule = module {

    single<NowPlayingRepository> { NowPlayingRepositoryImpl(get())}

    single<UpcomingRepository> { UpcomingRepositoryImpl(get())}
}