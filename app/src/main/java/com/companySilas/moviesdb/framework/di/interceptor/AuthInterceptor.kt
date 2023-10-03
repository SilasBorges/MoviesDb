package com.companySilas.moviesdb.framework.di.interceptor

import com.companySilas.moviesdb.util.Constants
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest: Request = chain.request()
        val modifiedUrl = originalRequest.url.newBuilder()
            .addQueryParameter("api_key", Constants.API_KEY)
            .addQueryParameter("language", Constants.LANGUAGE)
            .addQueryParameter("region", Constants.REGION)
            .build()
        val newRequest: Request = originalRequest.newBuilder()
            .url(modifiedUrl)
            .build()
        return chain.proceed(newRequest)
    }
}