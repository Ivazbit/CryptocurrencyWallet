package com.vulab.cryptoapp.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vulab.cryptoapp.common.Resource
import com.vulab.cryptoapp.domain.model.CoinData
import com.vulab.cryptoapp.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    //private val coinRepo: CoinRepo,
    private val getCoinsUseCase: GetCoinsUseCase
): ViewModel(){
    private val _state = mutableStateOf<CoinListState>(CoinListState())
    val state: State<CoinListState> = _state

    init{
        getCoins()
    }

    private fun getCoins() {
        getCoinsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CoinListState(coins = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = CoinListState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = CoinListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
    fun calculatePrice(coins: List<CoinData>): String {
        var convertedValue = 0.0
        coins.forEach { coin ->
            convertedValue += coin.price_usd * coin.quantity
        }

        return "%.2f".format(convertedValue)
    }

    //room
//
//    private val _response = MutableLiveData<CoinData>()
//    val response: LiveData<CoinData> = _response
//
//    //insert user details to room database
//    fun insertCoinDetails(coins: CoinData){
//        viewModelScope.launch(Dispatchers.IO) {
//            _response.postValue(coinRepo.createCoinRecords(coins))
//        }
//    }
}