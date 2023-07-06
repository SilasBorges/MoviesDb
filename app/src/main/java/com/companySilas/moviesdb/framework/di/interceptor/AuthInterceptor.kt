package com.companySilas.moviesdb.framework.di.interceptor

import com.companySilas.moviesdb.util.Constants
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AuthInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest: Request = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer" + Constants.API_KEY)
            .build()
        return chain.proceed(newRequest)
    }
}