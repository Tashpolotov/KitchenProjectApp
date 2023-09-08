package com.example.kitchenprojectapp.viewmodel

import com.example.domain.model.CategoryModel
import com.example.domain.model.HomeButtonModel
import com.example.domain.model.HomeModel
import com.example.domain.model.HomePopularModel

data class HomeState(
    val home : List<HomePopularModel> = emptyList(),
    val homeFood:List<HomeModel> = emptyList(),
    val homeButton:List<HomeButtonModel> = emptyList(),
    val categoryFood:List<CategoryModel> = emptyList(),
)