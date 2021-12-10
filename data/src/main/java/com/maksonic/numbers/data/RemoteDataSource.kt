package com.maksonic.numbers.data

/**
 * @Author: maksonic on 10.12.2021
 */
interface RemoteDataSource {
    suspend fun fetchNumberFact(number: Int): FactData

    class Base(private val apiService: ApiService) : RemoteDataSource {
        override suspend fun fetchNumberFact(number: Int): FactData {
            return apiService.getNumberFact(number)
        }
    }
}