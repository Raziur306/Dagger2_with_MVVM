package com.eritlab.dagger2.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eritlab.dagger2.models.Product
import com.eritlab.dagger2.repository.MainRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {
    init {
        viewModelScope.launch {
            repository.getProduct()
        }
    }

    val products: LiveData<List<Product>> get() = repository.products
}