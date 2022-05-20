//package com.vulab.cryptoapp.data
//
//import androidx.lifecycle.LiveData
//import androidx.room.Dao
//import androidx.room.Query
//import com.vulab.cryptoapp.domain.model.CoinData
//
//@Dao
//interface CoinDao {
//    @Query("SELECT * FROM coin_db")
//    fun getAllProducts(): List<CoinData>
//    abstract fun insertToRoomDatabase(coinData: CoinData): List<CoinData>
//}