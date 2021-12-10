package com.maksonic.numbers.data

import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @Author: maksonic on 10.12.2021
 */
interface ApiService {

    @GET("{number}/trivia?json")
    suspend fun getNumberFact(@Path("number") number: Int): FactData
}