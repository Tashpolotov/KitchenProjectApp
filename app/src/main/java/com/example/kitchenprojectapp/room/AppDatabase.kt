package com.example.kitchenprojectapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.room.KitchenDao
import com.example.domain.model.HomePopularModel
import com.example.domain.model.UserProfile

@Database(entities = [HomePopularModel::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    companion object{
        fun getInstance(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "app_db")
                .fallbackToDestructiveMigration().build()

        }
    }
    abstract fun getHomePopularDao():KitchenDao

}