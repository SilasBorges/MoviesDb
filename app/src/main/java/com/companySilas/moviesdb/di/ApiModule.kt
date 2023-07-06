package com.companySilas.moviesdb.di

import com.companySilas.moviesdb.framework.di.serviceModule

val listModules = listOf(coroutinesModules,
    viewModelModule,
    useCase,
    repositoryModule,
    serviceModule
)