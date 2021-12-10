package com.maksonic.numbers.data

import com.maksonic.numbers.core.Mapper
import com.maksonic.numbers.domain.FactDomain

/**
 * @Author: maksonic on 10.12.2021
 */
class DataToDomainMapper : Mapper<FactData, FactDomain> {
    override fun map(s: FactData) = FactDomain(s.number, s.type, s.text)
}