package com.muslimbd.zakat.features.domain.repository

import com.muslimbd.zakat.features.data.remote.entity.SSL
import com.muslimbd.zakat.features.data.remote.model.SSLResponseDto

interface PaymentApiRepo {
    suspend fun initiateSSL(body: SSL): SSLResponseDto
}