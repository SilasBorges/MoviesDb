package com.companysilas.core.domain.model

import com.google.gson.annotations.SerializedName

data class DataReview(
    val author: String,
    @SerializedName("author_details") val authorDetails: AuthorDetails,
    val content: String,
    val id: String
)