package com.example.kotlinexercise

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.kotlinexercise.Models.Products
import kotlinx.android.synthetic.main.activity_product_details.*

class ProductDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)
        val product = intent.getSerializableExtra("movie") as Products
        detailID.text= product.id
        detailName.text=product.name
        detailPrice.text="₱ " +product.price.toString()
        detailDescription.text= product.description
        checkBox.isChecked = product.isActive.toBoolean()

        getImage(product.imageUrl)
    }

    private fun getImage(url: String) {
        var circularProgressDrawable = CircularProgressDrawable(this)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()
        Glide.with(this)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(true)
            .placeholder(circularProgressDrawable)
            .into(detailProductImage)
    }
}