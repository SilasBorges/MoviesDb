package com.companySilas.moviesdb.di

import com.companysilas.core.usecase.base.AppCoroutinesDispatchers
import com.companysilas.core.usecase.base.CoroutinesDispatchers
import org.koin.dsl.module

val coroutinesModules = module {
    single<CoroutinesDispatchers> { AppCoroutinesDispatchers() }
}