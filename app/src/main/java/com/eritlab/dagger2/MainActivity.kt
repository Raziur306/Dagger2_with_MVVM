package com.eritlab.dagger2


import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.eritlab.dagger2.adapter.AdapterClickInterface
import com.eritlab.dagger2.adapter.ProductsAdapter
import com.eritlab.dagger2.databinding.ActivityMainBinding
import com.eritlab.dagger2.models.Product
import com.eritlab.dagger2.viewModel.MainViewModel
import com.eritlab.dagger2.viewModel.MainViewModelFactory
import javax.inject.Inject


class MainActivity : AppCompatActivity(), AdapterClickInterface {
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
            setProductAdapter(it)
        }

    }

    private fun setProductAdapter(item: List<Product>) {
        binding.productRecycler.apply {
            layoutManager =
                GridLayoutManager(this@MainActivity, 2, GridLayoutManager.VERTICAL, false)
            adapter = ProductsAdapter(item, this@MainActivity)
        }
    }

    override fun onClick(position: Int) {
        Log.d(TAG, "Item was clicked")
    }
}