package com.vulab.cryptoapp.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.vulab.cryptoapp.domain.model.CoinDetail

data class CoinDetailDto(
    val id: String,
    val price_usd: Double,
    val name: String,
    val rank: Int,
    val symbol: String
)

//                                 V Returns V
fun CoinDetailDto.toCoinDetail(): CoinDetail {
    return CoinDetail(
        id = id,
        price_usd = price_usd,
        name = name,
        rank = rank,
        symbol = symbol
    )
}