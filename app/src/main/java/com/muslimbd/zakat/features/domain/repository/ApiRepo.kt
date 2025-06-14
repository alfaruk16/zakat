package com.muslimbd.zakat.features.domain.repository

import com.muslimbd.zakat.features.data.remote.model.CategoryContentsDto

interface ApiRepo {
    suspend fun getCategoryContents(id: String): CategoryContentsDto
}