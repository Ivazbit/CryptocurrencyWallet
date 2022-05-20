package com.vulab.cryptoapp.domain.model

data class Coin(
    val id: String,
    val price_usd: Double,
    val name: String,
    val rank: Int,
    val symbol: String
)


