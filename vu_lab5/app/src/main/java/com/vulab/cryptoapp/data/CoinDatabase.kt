//package com.vulab.cryptoapp.data
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//import com.vulab.cryptoapp.domain.model.CoinData
//
//@Database(entities = [CoinData::class], version = 2, exportSchema = false)
//abstract class CoinDatabase: RoomDatabase() {
//    abstract fun coinDao(): CoinDao
//
//
//    companion object {
//
//        private var INSTANCE: CoinDatabase? = null
//
//        fun getInstance(context: Context): CoinDatabase {
//            synchronized(this) {
//                var instance = INSTANCE
//
//                if (instance == null) {
//                    instance = Room.databaseBuilder(
//                        context.applicationContext,
//                        CoinDatabase::class.java,
//                        "coin_database"
//                    ).fallbackToDestructiveMigration()
//                        .build()
//
//                    INSTANCE = instance
//                }
//                return instance
//            }
//        }
//    }
//}
