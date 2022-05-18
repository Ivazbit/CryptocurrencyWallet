package com.vulab.cryptoapp.domain.use_case.get_coins

import com.vulab.cryptoapp.common.Resource
import com.vulab.cryptoapp.data.remote.dto.toCoin
import com.vulab.cryptoapp.domain.model.Coin
import com.vulab.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
){
    private val coinList = arrayListOf<String>("btc-bitcoin", "eth-ethereum", "bnk-bankera", "usdp-paxos-standard-token")

     operator fun invoke(): Flow<Resource<List<Coin>>> = flow{
        try{
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().filter { it.id in coinList }.map {
                it.toCoin()
            }
            emit(Resource.Success<List<Coin>>(coins))
        }catch (e: HttpException){
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occurred"))
        }catch (e: IOException){
            emit(Resource.Error<List<Coin>>("Couldn't reach the server. Please, check your Internet connection"))
        }
     }
}