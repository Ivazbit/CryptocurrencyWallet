//package com.vulab.cryptoapp.domain.repository
//
//import com.vulab.cryptoapp.data.CoinDao
//import com.vulab.cryptoapp.domain.model.CoinData
//import javax.inject.Inject
//
//class CoinRepo @Inject constructor(private val coinDao: CoinDao) {
//
//    //insert user details to room
//    suspend fun createCoinRecords(coinData: CoinData): List<CoinData> {
//        return coinDao.insertToRoomDatabase(coinData)
//    }
//
//}