package com.plcoding.cryptocurrencyappyt.domain.use_case.get_coin

import com.plcoding.cryptocurrencyappyt.common.Resource
import com.plcoding.cryptocurrencyappyt.data.remote.dto.toCoin
import com.plcoding.cryptocurrencyappyt.data.remote.dto.toCoinDetail
import com.plcoding.cryptocurrencyappyt.domain.model.Coin
import com.plcoding.cryptocurrencyappyt.domain.model.CoinDetail
import com.plcoding.cryptocurrencyappyt.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject


// we should have one use case per actions like this instead of having a general one with
// multiple things to do
class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {

    // gets called automatically when using () for the operator override

    // it's a flow because we want to emit several values and remember that is cold so waits for observers
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        emit(Resource.Loading())
        emit(repository.getCoinById(coinId))
    }
}