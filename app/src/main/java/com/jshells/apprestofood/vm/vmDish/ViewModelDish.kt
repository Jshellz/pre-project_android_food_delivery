package com.jshells.apprestofood.vm.vmDish

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jshells.apprestofood.domain.model.DishModel
import com.jshells.apprestofood.domain.repository.DaoDish
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.mapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ViewModelDish(private val foodItemDao: DaoDish): ViewModel() {

    @OptIn(ExperimentalCoroutinesApi::class)
    val allFoodItem: StateFlow<List<DishModel>> = foodItemDao.getAllFoodItems()
        .mapLatest { it }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = emptyList()
        )

    suspend fun getFoodItemById(id: Int): DishModel {
        return foodItemDao.getFoodItemById(id)
    }

    fun insertDish(dishModel: DishModel) {
        viewModelScope.launch {
            foodItemDao.insertDish(dishModel)
        }
    }

    fun deleteDish(dishModel: DishModel) {
        viewModelScope.launch {
            foodItemDao.deleteDish(dishModel)
        }
    }
    fun updateDish(dishModel: DishModel) {
        viewModelScope.launch {
            foodItemDao.updateDish(dishModel)
        }
    }
}