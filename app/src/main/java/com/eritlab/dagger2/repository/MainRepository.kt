package com.eritlab.dagger2.repository


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.eritlab.dagger2.db.FackerDB
import com.eritlab.dagger2.models.Product
import com.eritlab.dagger2.retrofit.FackerApi
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val fackerApi: FackerApi,
    private val fackerDB: FackerDB
) {
    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> get() = _products

    suspend fun getProduct() {
        val result = fackerApi.getProducts()
        if (result.isSuccessful && result.body() != null) {
            _products.postValue(result.body())
            fackerDB.getFackerDAO().addProducts(result.body()!!)
        } else {
            _products.postValue(fackerDB.getFackerDAO().getProducts())
        }
    }
}