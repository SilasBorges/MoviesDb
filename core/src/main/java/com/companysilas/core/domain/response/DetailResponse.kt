package com.companysilas.core.domain.response

import com.companysilas.core.domain.model.Genre
import com.google.gson.annotations.SerializedName

data class DetailResponse(
    @SerializedName("adult") val adult: Boolean,
    @SerializedName("backdrop_path") val backdropPath: String,
    @SerializedName("genres") val genres: List<Genre>,
    @SerializedName("id") val id: Int,
    @SerializedName("original_title") val originalTitle: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("poster_path") val postPath: String,
    @SerializedName("runtime") val runtime: Int,
    @SerializedName("title") val title: String,
    @SerializedName("vote_average") val voteAverage: Double
)
