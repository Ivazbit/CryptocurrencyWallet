package com.vulab.cryptoapp.data.remote.dto

import com.vulab.cryptoapp.domain.model.Coin

data class CoinDto(
    val id: String,
    val price_usd: Double,
    val name: String,
    val rank: Int,
    val symbol: String
)

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        price_usd = price_usd,
        name = name,
        rank = rank,
        symbol = symbol
    )
}