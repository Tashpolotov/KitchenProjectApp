package com.example.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CategoryModel (
    @PrimaryKey(autoGenerate = false)
    val img:Int,
    val name:String,
    val foodName:String,
    val gram:String,
    val kcal:String,
    val calories:String,
    val protein:String,
    val fat:String,
    val carbs:String,
    val foodIngredient:String,
    val foodInfo:String
    )