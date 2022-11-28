package com.eritlab.dagger2.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.eritlab.dagger2.repository.MainRepository
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory @Inject constructor(private val repository: MainRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}