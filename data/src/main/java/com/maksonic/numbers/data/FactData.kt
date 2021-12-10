package com.maksonic.numbers.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/**
 * @Author: maksonic on 10.12.2021
 */
@Serializable
data class FactData(
    @SerialName("number")
    val number: Int,
    @SerialName("type")
    val type: String,
    @SerialName("text")
    val text: String
)