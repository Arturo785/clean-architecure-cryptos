package com.plcoding.cryptocurrencyappyt.domain.repository

import com.plcoding.cryptocurrencyappyt.common.Resource
import com.plcoding.cryptocurrencyappyt.domain.model.Coin
import com.plcoding.cryptocurrencyappyt.domain.model.CoinDetail


// this repositories are only for have the structure of the data needed

interface CoinRepository {

    suspend fun getCoins(): Resource<List<Coin>>

    suspend fun getCoinById(coinId: String): Resource<CoinDetail>

}