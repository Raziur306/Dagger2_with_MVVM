package com.eritlab.dagger2.retrofit

import com.eritlab.dagger2.models.Product
import retrofit2.Response
import retrofit2.http.GET

interface FackerApi {
    @GET("products")
    suspend fun getProducts(): Response<List<Product>>
}