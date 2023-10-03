package com.companysilas.core.domain.response

import com.companysilas.core.domain.model.AuthorDetails
import com.google.gson.annotations.SerializedName

data class DataReview(
    @SerializedName("author") val author: String,
    @SerializedName("author_details") val authorDetails: AuthorDetails,
    @SerializedName("content") val content: String,
    @SerializedName("id") val id: String
)