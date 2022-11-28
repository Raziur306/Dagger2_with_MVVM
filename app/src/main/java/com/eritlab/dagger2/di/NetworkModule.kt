package com.eritlab.dagger2.di

import com.eritlab.dagger2.retrofit.FackerApi
import com.eritlab.dagger2.utils.Constant
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideFackerAPI(retrofit: Retrofit): FackerApi {
        return retrofit.create(FackerApi::class.java)
    }

}