package com.muslimbd.zakat.features.data.remote

import com.muslimbd.zakat.core.util.LocalConstant
import com.muslimbd.zakat.core.util.AppConstants
import com.muslimbd.zakat.features.data.remote.model.CategoryContentsDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Path

interface Apis {

    @Headers("Content-Type: application/json")
    @GET("TextContent/bycategory/{id}/${AppConstants.search}/1/0")
    suspend fun getCategoryContents(
        @Header("Authorization") token: String = LocalConstant.freeToken,
        @Path("id") id: String
    ): CategoryContentsDto
}
