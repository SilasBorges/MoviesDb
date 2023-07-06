package com.companySilas.moviesdb

import android.app.Application
import com.companySilas.moviesdb.di.listModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

class MovieApplication : Application(){

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MovieApplication)
            loadKoinModules(listModules)
        }
    }
}