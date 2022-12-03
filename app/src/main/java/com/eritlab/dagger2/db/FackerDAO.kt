package com.eritlab.dagger2.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.eritlab.dagger2.models.Product

@Dao
interface FackerDAO {
    @Insert
    suspend fun addProducts(product: List<Product>)

    @Query("SELECT * FROM Product")
    suspend fun getProducts(): List<Product>
}