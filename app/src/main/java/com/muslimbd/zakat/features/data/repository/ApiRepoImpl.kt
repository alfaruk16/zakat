package com.muslimbd.zakat.features.data.repository

import com.muslimbd.zakat.features.data.remote.Apis
import com.muslimbd.zakat.features.data.remote.model.CategoryContentsDto
import com.muslimbd.zakat.features.domain.repository.ApiRepo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiRepoImpl @Inject constructor(
    private val api: Apis
) : ApiRepo {
    override suspend fun getCategoryContents(id: String): CategoryContentsDto {
        return api.getCategoryContents(id = id)
    }
}