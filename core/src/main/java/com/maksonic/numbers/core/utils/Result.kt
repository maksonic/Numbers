package com.maksonic.numbers.core.utils

/**
 * @Author: maksonic on 10.12.2021
 */
sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}
