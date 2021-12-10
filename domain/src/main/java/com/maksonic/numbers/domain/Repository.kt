package com.maksonic.numbers.domain

import kotlinx.coroutines.flow.Flow

/**
 * @Author: maksonic on 10.12.2021
 */
interface Repository {
    suspend fun fetchNumberFact(number: Int) : Flow<Result<FactDomain>>
}