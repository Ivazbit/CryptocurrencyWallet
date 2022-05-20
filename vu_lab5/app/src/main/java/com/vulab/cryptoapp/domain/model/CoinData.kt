package com.vulab.cryptoapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity(tableName = "coin_db")
data class CoinData(
   // @PrimaryKey
    val id: String,
    val price_usd: Double,
    val name: String,
    val rank: Int,
    val symbol: String,
    val quantity: Double
)