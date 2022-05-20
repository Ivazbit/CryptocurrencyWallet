package com.vulab.cryptoapp.presentation.coin_list

import com.vulab.cryptoapp.domain.model.CoinData

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<CoinData> = emptyList(),
    val error: String = ""
)
