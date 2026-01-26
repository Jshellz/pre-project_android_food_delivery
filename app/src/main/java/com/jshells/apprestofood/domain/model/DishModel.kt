package com.jshells.apprestofood.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jshells.apprestofood.presentation.FoodCategory

@Entity(tableName = "dish")
data class DishModel (
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name: String,
    var description: String,
    var price: String,
    var category: FoodCategory,
    var imageUrl: String = ""
)