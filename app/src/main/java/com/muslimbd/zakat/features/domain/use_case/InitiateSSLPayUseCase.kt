package com.muslimbd.zakat.features.domain.use_case

import com.google.gson.Gson
import com.muslimbd.zakat.core.util.Async
import com.muslimbd.zakat.features.data.remote.entity.SSL
import com.muslimbd.zakat.features.data.remote.model.ErrorDto
import com.muslimbd.zakat.features.data.remote.model.SSLResponseDto
import com.muslimbd.zakat.features.domain.repository.PaymentApiRepo
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class InitiateSSLPayUseCase @Inject constructor(private val paymentApiRepo: PaymentApiRepo) {

    operator fun invoke(body: SSL): kotlinx.coroutines.flow.Flow<Async<SSLResponseDto>> = flow {
        try {
            emit(Async.Loading())
            val ssl = paymentApiRepo.initiateSSL(body)
            emit(Async.Success(ssl))
        } catch (e: HttpException) {
            val error: ErrorDto = Gson().fromJson(
                e.response()?.errorBody()?.charStream(),
                ErrorDto::class.java
            )
            emit(Async.Error(error.message ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Async.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}