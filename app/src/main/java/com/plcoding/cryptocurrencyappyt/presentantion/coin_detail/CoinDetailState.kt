package com.plcoding.cryptocurrencyappyt.presentantion.coin_detail

import com.plcoding.cryptocurrencyappyt.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)