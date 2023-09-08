package com.example.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

data class UserProfile(

    val id: String,
    val username: String,
    val photoUri: String? // URI или путь к фотографии пользователя
)