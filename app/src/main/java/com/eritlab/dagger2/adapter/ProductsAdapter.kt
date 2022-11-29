package com.eritlab.dagger2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.eritlab.dagger2.databinding.ProductItemBinding
import com.eritlab.dagger2.models.Product

class ProductsAdapter(
    private val productList: List<Product>,
    private val adapterClickInterface: AdapterClickInterface
) :
    RecyclerView.Adapter<ProductsAdapter.ViewModel>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewModel {
        val binding = ProductItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewModel(binding, adapterClickInterface)
    }

    override fun onBindViewHolder(holder: ViewModel, position: Int) {
        holder.binding.productTitle.text = productList[position].title
        holder.binding.mainPrice.text = (productList[position].price * 1.5).toString()
        holder.binding.discountPrice.text = productList[position].price.toString()
        Glide.with(holder.binding.productImage.context).load(productList[position].image)
            .into(holder.binding.productImage)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    class ViewModel(
        val binding: ProductItemBinding,
        private val adapterClickInterface: AdapterClickInterface
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    adapterClickInterface.onClick(position)
                }
            }
        }
    }

}