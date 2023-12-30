package com.softland.machinetest.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query



@Dao
interface ProductDao {
    @Query("SELECT * FROM ItemsItem")
    fun getAllCategory(): LiveData<List<ItemsItem?>>


    @Query("SELECT * FROM ItemsItem WHERE id = :id")
    fun getCategory(id: Int): LiveData<List<ItemsItem?>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(itemsItem: ItemsItem)

    @Delete
    fun delete(itemsItem: ItemsItem)  // Change parameter to non-nullable

}
