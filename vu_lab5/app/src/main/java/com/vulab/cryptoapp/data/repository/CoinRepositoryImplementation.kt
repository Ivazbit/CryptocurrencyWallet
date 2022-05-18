package com.vulab.cryptoapp.data.repository

import com.vulab.cryptoapp.data.remote.dto.CoinDetailDto
import com.vulab.cryptoapp.data.remote.dto.CoinDto
import com.vulab.cryptoapp.data.remote.dto.CoinPaprikaApi
import com.vulab.cryptoapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImplementation @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository{

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(id: String): CoinDetailDto {
        return api.getCoinById(id)
    }
}