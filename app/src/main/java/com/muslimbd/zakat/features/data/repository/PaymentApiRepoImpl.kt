package com.muslimbd.zakat.features.data.repository


import com.muslimbd.zakat.features.data.remote.PaymentApis
import com.muslimbd.zakat.features.data.remote.entity.SSL
import com.muslimbd.zakat.features.data.remote.model.SSLResponseDto
import com.muslimbd.zakat.features.domain.repository.PaymentApiRepo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PaymentApiRepoImpl @Inject constructor(private val paymentApis: PaymentApis) :
    PaymentApiRepo {
    override suspend fun initiateSSL(body: SSL): SSLResponseDto {
        return paymentApis.initiateSSL(body)
    }
}