package com.plcoding.cryptocurrencyappyt.data.repository

import com.plcoding.cryptocurrencyappyt.common.Resource
import com.plcoding.cryptocurrencyappyt.data.remote.CoinPaprikaApi
import com.plcoding.cryptocurrencyappyt.data.remote.dto.toCoin
import com.plcoding.cryptocurrencyappyt.data.remote.dto.toCoinDetail
import com.plcoding.cryptocurrencyappyt.domain.model.Coin
import com.plcoding.cryptocurrencyappyt.domain.model.CoinDetail
import com.plcoding.cryptocurrencyappyt.domain.repository.CoinRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): Resource<List<Coin>> {
        return try {
            val coin = api.getCoins().map { it.toCoin() }
            Resource.Success(coin)
        } catch (e: HttpException) {
            Resource.Error(e.localizedMessage ?: "An unexpected error occured")
        } catch (e: IOException) {
            Resource.Error("Couldn't reach server. Check your internet connection.")
        }
    }

    override suspend fun getCoinById(coinId: String): Resource<CoinDetail> {
        return try {
            val coin = api.getCoinById(coinId).toCoinDetail()
            Resource.Success(coin)
        } catch (e: HttpException) {
            Resource.Error(e.localizedMessage ?: "An unexpected error occured")
        } catch (e: IOException) {
            Resource.Error("Couldn't reach server. Check your internet connection.")
        }
    }

}