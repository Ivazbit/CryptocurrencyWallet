package com.vulab.cryptoapp.domain.use_case.get_coins

import com.vulab.cryptoapp.common.Resource
import com.vulab.cryptoapp.data.remote.dto.toCoin
import com.vulab.cryptoapp.domain.model.Coin
import com.vulab.cryptoapp.domain.model.CoinData
import com.vulab.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    private val coinList = arrayListOf<String>(
        "bnk-bankera",
        "btc-bitcoin",
        "eth-ethereum",
        "usdp-paxos-standard-token"
    )

    data class CurrencyBalance(
        val id: String,
        val quantity: String
    )

    private val coinBalance: List<CurrencyBalance> = listOf(
        CurrencyBalance("bnk-bankera", "131231567"),
        CurrencyBalance("btc-bitcoin", "0.31244124"),
        CurrencyBalance("eth-ethereum", "0.327834478541236547"),
        CurrencyBalance("usdp-paxos-standard-token", "0.31244124")
    )

    operator fun invoke(): Flow<Resource<List<CoinData>>> = flow {
        try {
            emit(Resource.Loading<List<CoinData>>())
            val coins = repository.getCoins().filter { it.id in coinList }.map {
                it.toCoin()
            }
            val newCoins = convertLists(coinBalance, coins)
            emit(Resource.Success<List<CoinData>>(newCoins))
        } catch (e: HttpException) {
            emit(
                Resource.Error<List<CoinData>>(
                    e.localizedMessage ?: "An unexpected error occurred"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error<List<CoinData>>("Couldn't reach the server. Please, check your Internet connection"))
        }
    }

    private fun convertLists(
        currencyBalances: List<CurrencyBalance>,
        coins: List<Coin>
    ): List<CoinData> =
        currencyBalances.mapNotNull { currencyBalance ->
            coins.firstOrNull { coin -> coin.id == currencyBalance.id }
                ?.let { coin ->
                    CoinData(
                        coin.id,
                        coin.price_usd,
                        coin.name,
                        coin.rank,
                        coin.symbol,
                        currencyBalance.quantity.toDouble()
                    )
                }
        }
}