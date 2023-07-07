package com.companySilas.moviesdb.di

import com.companySilas.moviesdb.framework.repositoryImpl.NowPlayingRepositoryImpl
import com.companysilas.core.repository.NowPlayingRepository
import org.koin.dsl.module

val repositoryModule = module {

    single<NowPlayingRepository> { NowPlayingRepositoryImpl(get())}

}