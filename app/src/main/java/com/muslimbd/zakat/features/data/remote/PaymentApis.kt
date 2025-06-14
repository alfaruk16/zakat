package com.muslimbd.zakat.features.data.remote

import com.muslimbd.zakat.features.data.remote.entity.SSL
import com.muslimbd.zakat.features.data.remote.model.SSLResponseDto
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface PaymentApis {
    @Headers("Content-Type: application/json")
    @POST("api/SSLPayInitiateDPRng")
    suspend fun initiateSSL(@Body ssl: SSL): SSLResponseDto

}