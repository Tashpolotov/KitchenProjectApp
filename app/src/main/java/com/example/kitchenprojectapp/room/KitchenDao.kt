package com.example.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.domain.model.HomePopularModel

@Dao
interface KitchenDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insertHomePopularList(list: List<HomePopularModel>)

    @Query("SELECT * FROM HOMEPOPULARMODEL")
     fun getHomePopular():List<HomePopularModel>
}