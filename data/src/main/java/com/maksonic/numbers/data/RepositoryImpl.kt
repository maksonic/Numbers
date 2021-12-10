package com.maksonic.numbers.data

import com.maksonic.numbers.domain.FactDomain
import com.maksonic.numbers.domain.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.maksonic.numbers.core.utils.Result
import kotlinx.coroutines.delay

/**
 * @Author: maksonic on 10.12.2021
 */
class RepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val mapper: DataToDomainMapper,
) : Repository {

    override suspend fun fetchNumberFact(number: Int): Flow<Result<FactDomain>> = flow {
        try {
            val remoteData = remoteDataSource.fetchNumberFact(number)
            delay(3000)
            emit(Result.Success(mapper.map(remoteData)))
        } catch (e: Exception) {
            emit(Result.Error(e))
        }
    }
}