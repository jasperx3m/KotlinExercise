package com.example.kotlinexercise.Adapters

import com.example.kotlinexercise.Models.Products
import kotlinx.android.synthetic.main.layout_products.view.*


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.example.kotlinexercise.R
import kotlinx.android.synthetic.main.layout_movie.view.*

class ProductsAdapter (private var products: List<Products>, var context: Context, private var onClickListener: OnProductClickListener) :
    RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder{
        return ProductsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_products,parent,false)
            ,onClickListener)
    }
    override fun getItemCount()=products.size

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        val product = products[position]
        holder.itemView.displayName.text = product.name
        holder.itemView.displayPrice.text = product.price.toString()
        holder.itemView.displayDescription.text = product.description
        var circularProgressDrawable = CircularProgressDrawable(context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()
        Glide.with(context)
            .load(product.imageUrl)
            .placeholder(circularProgressDrawable)
            .into(holder.itemView.productImage)
    }

    class ProductsViewHolder(itemView: View, var OnProductClickListener: OnProductClickListener) : RecyclerView.ViewHolder(itemView)
        , View.OnClickListener
        , View.OnLongClickListener{

        init {
            itemView.setOnClickListener(this)
            itemView.setOnLongClickListener(this)
        }
        override fun onClick(view: View) {
            OnProductClickListener.onProductClick(adapterPosition)
        }
        override fun onLongClick(view: View): Boolean {
            OnProductClickListener.onProductLongClick(adapterPosition)
            return true
        }

    }
    interface OnProductClickListener{
        fun onProductClick(position: Int)
        fun onProductLongClick(position: Int)
    }
}