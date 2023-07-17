package com.companysilas.core.domain.response

import com.companysilas.core.domain.model.DataReview
import com.google.gson.annotations.SerializedName

data class ReviewsResponse(
    val id: Int,
    val page: Int,
    val results: List<DataReview>,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("total_results") val totalResults: Int
)