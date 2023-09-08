package com.example.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HomeButtonModel(
    @PrimaryKey(autoGenerate = false)
    val name:String,


)
