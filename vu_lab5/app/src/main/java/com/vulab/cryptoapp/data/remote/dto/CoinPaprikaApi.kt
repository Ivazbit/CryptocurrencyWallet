package com.vulab.cryptoapp.data.remote.dto

import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("/v1/ticker")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/ticker/{id}")
    suspend fun getCoinById(@Path("id") coinId: String): CoinDetailDto
}