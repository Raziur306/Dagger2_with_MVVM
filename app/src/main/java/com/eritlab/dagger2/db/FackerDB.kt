package com.eritlab.dagger2.db


import androidx.room.Database
import androidx.room.RoomDatabase
import com.eritlab.dagger2.models.Product

@Database(entities = [Product::class], version = 1)
abstract class FackerDB : RoomDatabase() {
    abstract fun getFackerDAO(): FackerDAO
}