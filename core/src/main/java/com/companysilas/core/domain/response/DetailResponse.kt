package com.companysilas.core.domain.response

import com.companysilas.core.domain.model.Genre
import com.google.gson.annotations.SerializedName

data class DetailResponse(
    val adult: Boolean,
    @SerializedName("backdrop_path") val backdropPath: String,
    val genres: List<Genre>,
    val id: Int,
    @SerializedName("original_title")val originalTitle: String,
    val overview: String,
    @SerializedName("poster_path")val postPath: String,
    val runtime: Int,
    val title: String,
    @SerializedName("vote_average")val voteAverage: Double
)
