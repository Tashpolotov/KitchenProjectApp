package com.example.domain.repository

import com.example.domain.model.CategoryModel
import com.example.domain.model.HomeButtonModel
import com.example.domain.model.HomeModel
import com.example.domain.model.HomePopularModel

interface KitchenRepository {

     fun getHomeImgFood(id:String):List<HomePopularModel>

    fun getHomeFood(id:String):List<HomeModel>

    fun getHomeButton():List<HomeButtonModel>

    fun getCategory():List<CategoryModel>
}