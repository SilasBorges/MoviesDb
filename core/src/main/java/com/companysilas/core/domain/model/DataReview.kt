package com.companysilas.core.domain.model

data class DataReview(
    val author: String,
    val authorDetails: AuthorDetails,
    val content: String,
    val id: String
)