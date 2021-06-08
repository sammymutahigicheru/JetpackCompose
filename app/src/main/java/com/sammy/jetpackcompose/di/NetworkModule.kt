package com.sammy.jetpackcompose.di

import com.sammy.jetpackcompose.BuildConfig
import com.sammy.jetpackcompose.network.ApiService
import com.sammy.jetpackcompose.utils.loggingInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.Protocol
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Qualifier
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {
    private var BASE_URL =
        if (BuildConfig.DEBUG) "https://proto-energy.github.io/" else "https://proto-energy.github.io/"


    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .protocols(listOf(Protocol.HTTP_2, Protocol.HTTP_1_1))
            .addInterceptor { chain ->
                val request = chain.request()
                val authRequest = request.newBuilder()
                    .header("Content-Type", "application/json")
                    .build()


                return@addInterceptor chain.proceed(authRequest)
            }
            .addNetworkInterceptor(loggingInterceptor)
        return builder.build()
    }


    @Singleton
    @Provides
    @ApiRetrofit
    fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    @Singleton
    @Provides
    fun provideMoshi(): Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()


    @Provides
    fun provideApiService(@ApiRetrofit retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)


    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class ApiRetrofit
}