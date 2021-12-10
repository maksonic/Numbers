package com.maksonic.numbers.data

import com.maksonic.numbers.domain.Repository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @Author: maksonic on 10.12.2021
 */
private val BASE_URL = named("BASE_URL")
val dataModule = module {

    single {
        provideRetrofit(
            baseUrl = get(BASE_URL),
            client = get()
        )
    }
    single<Repository> { RepositoryImpl(mapper = get(), remoteDataSource = get()) }

    single<RemoteDataSource> { RemoteDataSource.Base(get()) }

    single { provideOkHttpClient() }

    factory(BASE_URL) { "http://numbersapi.com/" }
    factory { provideApiService(get()) }
    factory { DataToDomainMapper() }
}

private fun provideApiService(retrofit: Retrofit) = retrofit.create(ApiService::class.java)

private fun provideRetrofit(baseUrl: String, client: OkHttpClient): Retrofit {

    return Retrofit.Builder()
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl)
        .build()
}

private fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .writeTimeout(10, TimeUnit.SECONDS)
        .addInterceptor(
            HttpLoggingInterceptor()
                .apply {
                    level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                    else HttpLoggingInterceptor.Level.NONE
                }).build()
}