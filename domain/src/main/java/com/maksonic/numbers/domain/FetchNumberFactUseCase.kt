package com.maksonic.numbers.domain

import com.maksonic.numbers.core.CoroutineDispatchers
import kotlinx.coroutines.flow.flowOn

/**
 * @Author: maksonic on 10.12.2021
 */
class FetchNumberFactUseCase(
    private val repository: Repository,
    private val dispatchers: CoroutineDispatchers
) {
    suspend operator fun invoke(number: Int) =
        repository.fetchNumberFact(number).flowOn(dispatchers.io)
}