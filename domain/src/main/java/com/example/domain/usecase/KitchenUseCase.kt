package com.example.domain.usecase

import com.example.domain.repository.KitchenRepository

class KitchenUseCase(private val repository: KitchenRepository) {

    operator fun invoke(id:String){
        repository.getHomeFood(id)
        repository.getHomeButton()
        repository.getHomeImgFood(id)
        repository.getCategory()
    }

}