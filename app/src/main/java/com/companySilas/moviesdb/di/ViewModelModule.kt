package com.companySilas.moviesdb.di

import com.companySilas.moviesdb.presentation.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        HomeViewModel(get())
    }
}