package com.jshells.apprestofood.domain.model

import com.jshells.apprestofood.presentation.FoodCategory

data class DishModel (
    val id: Int,
    val name: String,
    val description: String,
    val price: String,
    val category: FoodCategory,
    val imageUrl: String = ""
)