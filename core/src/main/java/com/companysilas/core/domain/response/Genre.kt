package com.companysilas.core.domain.response

import com.google.gson.annotations.SerializedName

data class Genre(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String
)