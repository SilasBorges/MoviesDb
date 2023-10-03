package com.companysilas.core.domain.response

import com.companysilas.core.domain.model.DataNowPlaying
import com.companysilas.core.domain.model.DateExhibition
import com.google.gson.annotations.SerializedName

data class NowPlayingResponse(
    @SerializedName("dates") val dates: DateExhibition,
    @SerializedName("page") val page: Int,
    @SerializedName("results") val results: List<DataNowPlaying>,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("total_results") val totalResults: Int
)
