package com.eritlab.dagger2

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.eritlab.dagger2.databinding.ActivityMainBinding
import com.eritlab.dagger2.repository.MainRepository
import com.eritlab.dagger2.viewModel.MainViewModel
import com.eritlab.dagger2.viewModel.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var viewModelProvider: MainViewModel
    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        (applicationContext as FackerApplication).applicationComponent.inject(this)
        viewModelProvider = ViewModelProvider(this, mainViewModelFactory)[MainViewModel::class.java]
        viewModelProvider.products.observe(this) {
            Log.d(TAG, it.toString())
        }

    }
}