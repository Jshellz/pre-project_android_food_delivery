package com.jshells.apprestofood.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jshells.apprestofood.presentation.FoodCategory

@Entity(tableName = "dish")
data class DishModel (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val description: String,
    val price: String,
    val category: FoodCategory,
    val imageUrl: String = ""
)