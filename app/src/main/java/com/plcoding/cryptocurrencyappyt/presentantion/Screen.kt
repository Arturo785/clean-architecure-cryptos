package com.plcoding.cryptocurrencyappyt.presentantion


// to handle the routes that our app can take
sealed class Screen(val route: String) {
    object CoinListScreen : Screen("coin_list_screen")
    object CoinDetailScreen : Screen("coin_detail_screen")
}