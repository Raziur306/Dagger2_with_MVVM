package com.eritlab.dagger2.di

import android.content.Context
import androidx.room.Room
import com.eritlab.dagger2.db.FackerDB
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(context: Context): FackerDB {
        return Room.databaseBuilder(context, FackerDB::class.java, "FackerDB").build()
    }
}