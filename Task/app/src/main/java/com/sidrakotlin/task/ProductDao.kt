package com.sidrakotlin.task

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ProductDao {

    @Insert
    suspend fun insertProduct(product: Product)

    @Delete
    suspend fun deleteProduct(product: Product)

    @Update
    suspend fun updateProduct(product: Product)


    @Query("Select * from product order by name ASC")
    fun getAllProduct(): LiveData<List<Product>>




}