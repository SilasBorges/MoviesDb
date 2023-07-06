package com.companySilas.moviesdb.framework.service

import com.companysilas.core.domain.response.NowPlayingResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ApiService {

    @GET("now_playing")
    suspend fun nowPlaying(
        @QueryMap queries: Map<String, String>
    ) : NowPlayingResponse
}