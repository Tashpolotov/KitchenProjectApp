package com.example.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HomeModel(
    @PrimaryKey(autoGenerate = false)
    val id:String,
    val img:Int,
)
