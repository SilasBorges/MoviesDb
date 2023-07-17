package com.companysilas.core.repository

import com.companysilas.core.domain.response.DetailResponse

interface DetailRepository {

    suspend fun detail(id: Int): DetailResponse
}