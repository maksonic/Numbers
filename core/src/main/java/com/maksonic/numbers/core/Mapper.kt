package com.maksonic.numbers.core

/**
 * @Author: maksonic on 10.12.2021
 */
interface Mapper<S, R> {
    fun map(s: S): R
}