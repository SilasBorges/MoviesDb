package com.companySilas.moviesdb.di

import com.companySilas.moviesdb.framework.repositoryImpl.DetailRepositoryImpl
import com.companySilas.moviesdb.framework.repositoryImpl.MovieSimilarRepositoryImpl
import com.companySilas.moviesdb.framework.repositoryImpl.NowPlayingRepositoryImpl
import com.companySilas.moviesdb.framework.repositoryImpl.PopularRepositoryImpl
import com.companySilas.moviesdb.framework.repositoryImpl.ReviewsRepositoryImpl
import com.companySilas.moviesdb.framework.repositoryImpl.TopRatedRepositoryImpl
import com.companySilas.moviesdb.framework.repositoryImpl.UpcomingRepositoryImpl
import com.companysilas.core.repository.DetailRepository
import com.companysilas.core.repository.MovieSimilarRepository
import com.companysilas.core.repository.NowPlayingRepository
import com.companysilas.core.repository.PopularRepository
import com.companysilas.core.repository.ReviewsRepository
import com.companysilas.core.repository.TopRatedRepository
import com.companysilas.core.repository.UpcomingRepository
import org.koin.dsl.module

val repositoryModule = module {

    single<NowPlayingRepository> { NowPlayingRepositoryImpl(get())}

    single<UpcomingRepository> { UpcomingRepositoryImpl(get())}

    single<PopularRepository> { PopularRepositoryImpl(get())}

    single<TopRatedRepository> { TopRatedRepositoryImpl(get())}

    single<DetailRepository> { DetailRepositoryImpl(get())}

    single<ReviewsRepository> { ReviewsRepositoryImpl(get())}

    single<MovieSimilarRepository> { MovieSimilarRepositoryImpl(get())}
}