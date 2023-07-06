package com.companysilas.core.domain.response

import com.companysilas.core.domain.model.DataNowPlaying
import com.companysilas.core.domain.model.DateExibhition
import com.google.gson.annotations.SerializedName

data class NowPlayingResponse(
    val dates: DateExibhition,
    val page: Int,
    val results: List<DataNowPlaying>,
    @SerializedName("total_pages") val totalPages: Int,
    @SerializedName("total_results") val totalResults: Int
)
