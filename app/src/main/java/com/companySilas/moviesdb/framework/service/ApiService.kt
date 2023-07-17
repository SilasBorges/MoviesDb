package com.companySilas.moviesdb.framework.service

import com.companysilas.core.domain.response.DetailResponse
import com.companysilas.core.domain.response.NowPlayingResponse
import com.companysilas.core.domain.response.ReviewsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap
import retrofit2.http.QueryName

interface ApiService {

    @GET("now_playing")
    suspend fun nowPlaying(
        @QueryMap queries: Map<String, String>
    ) : NowPlayingResponse

    @GET("upcoming")
    suspend fun upcoming(
        @QueryMap queries: Map<String, String>
    ) : NowPlayingResponse

    @GET("popular")
    suspend fun popular(
        @QueryMap queries: Map<String, String>
    ) : NowPlayingResponse

    @GET("top_rated")
    suspend fun topRated(
        @QueryMap queries: Map<String, String>
    ) : NowPlayingResponse

    @GET("{id}")
    suspend fun details(
        @Path("id") id: Int
    ) : DetailResponse

    @GET("{id}/reviews")
    suspend fun getReviews(
        @Path("id") id: Int,
        @QueryMap queries: Map<String, String>
    ) : ReviewsResponse

    @GET("{id}/similar")
    suspend fun getMovieSimilar(
        @Path("id") id: Int,
        @QueryMap queries: Map<String, String>
    ) : NowPlayingResponse
}