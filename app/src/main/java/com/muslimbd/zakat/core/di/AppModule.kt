package com.muslimbd.zakat.core.di

import com.muslimbd.zakat.features.data.remote.Apis
import com.muslimbd.zakat.features.data.remote.PaymentApis
import com.muslimbd.zakat.features.data.repository.ApiRepoImpl
import com.muslimbd.zakat.features.data.repository.PaymentApiRepoImpl
import com.muslimbd.zakat.features.domain.repository.ApiRepo
import com.muslimbd.zakat.features.domain.repository.PaymentApiRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val BASE_URL = "https://api/"
    private const val PAYMENT_BASE_URL = "https://api/"


//    @Provides
//    @Singleton
//    fun provideQuranRepo(quranDao: QuranDao): QuranRepo {
//        return QuranRepoImpl(
//            quranDao, CoroutineModule.provideDefaultDispatcher(),
//            CoroutineModule.provideCoroutineScope(CoroutineModule.provideIoDispatcher())
//        )
//    }
//
//    @Provides
//    @Singleton
//    fun provideSurahRepo(surahDao: SurahDao): SurahRepo {
//        return SurahRepoImpl(
//            surahDao, CoroutineModule.provideDefaultDispatcher(),
//            CoroutineModule.provideCoroutineScope(CoroutineModule.provideIoDispatcher())
//        )
//    }

    @Provides
    @Singleton
    fun provideApi(): Apis {
        val client = OkHttpClient.Builder().apply {
            addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            readTimeout(10, TimeUnit.SECONDS)
            writeTimeout(10, TimeUnit.SECONDS)
        }.build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Apis::class.java)
    }

    @Provides
    @Singleton
    fun provideApiRepo(api: Apis): ApiRepo {
        return ApiRepoImpl(api)
    }

    @Provides
    @Singleton
    fun providePaymentApi(): PaymentApis {
        val client = OkHttpClient.Builder().apply {
            addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            readTimeout(10, TimeUnit.SECONDS)
            writeTimeout(10, TimeUnit.SECONDS)
        }.build()

        return Retrofit.Builder()
            .baseUrl(PAYMENT_BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PaymentApis::class.java)
    }

    @Provides
    @Singleton
    fun providePaymentRepo(api: PaymentApis): PaymentApiRepo {
        return PaymentApiRepoImpl(api)
    }


}