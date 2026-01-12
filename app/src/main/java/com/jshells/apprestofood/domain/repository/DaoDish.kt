package com.jshells.apprestofood.domain.repository

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import androidx.room.Update
import com.jshells.apprestofood.domain.model.DishModel
import kotlinx.coroutines.flow.Flow

@Dao
interface DaoDish {

    @Query("SELECT * FROM dish")
    fun getAllFoodItems(): Flow<List<DishModel>>

    @Query("SELECT * FROM dish WHERE id =:id")
    suspend fun getFoodItemById(id: Int): DishModel

    @Insert(onConflict = REPLACE)
    suspend fun insertDish(dishModel: DishModel)

    @Delete
    suspend fun deleteDish(dishModel: DishModel)

    @Update
    suspend fun updateDish(dishModel: DishModel)



}