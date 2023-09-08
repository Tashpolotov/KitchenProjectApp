package com.example.kitchenprojectapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.repository.KitchenRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val repository: KitchenRepository):ViewModel() {

    private val _home = MutableStateFlow(HomeState())
    val home : StateFlow<HomeState> = _home.asStateFlow()

    fun loadCategoryFood(){
        viewModelScope.launch {
            val categoryFood = repository.getCategory()
            _home.value = _home.value.copy(categoryFood = categoryFood)
        }
    }

    fun loadHome(id: String) {
        viewModelScope.launch {
            try {
                val homeImg = withContext(Dispatchers.IO) {
                    repository.getHomeImgFood(id)
                }
                _home.value = _home.value.copy(home = homeImg)
            } catch (e: Exception) {
                // Обработка ошибки, если таковая возникнет
            }
        }
    }

    fun loadHomeFood(id:String) {
        viewModelScope.launch {
            val homeFood = repository.getHomeFood(id)
            _home.value = _home.value.copy(homeFood = homeFood)
        }
    }

    fun loadHomeCategory(){
        viewModelScope.launch {
            val homeCategory = repository.getHomeButton()
            _home.value = _home.value.copy(homeButton = homeCategory)
        }
    }

}