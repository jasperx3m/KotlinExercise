package com.example.kotlinexercise

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinexercise.API.ProductsApi
import com.example.kotlinexercise.Models.Products
import kotlinx.android.synthetic.main.activity_product_edit_form.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductEditForm : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_edit_form)
        val product = intent.getSerializableExtra("movie") as Products
        editID.setText(product.id)
        editName.setText(product.name)
        editDescription.setText(product.description)
        editImageUrl.setText(product.imageUrl)
        editIsActive.isChecked=product.isActive.toBoolean()
        editPrice.setText(product.price)

        submitEditProduct.setOnClickListener{
            val name = editName.text.trim().toString()
            val price = editPrice.text.trim().toString()
            val description = editDescription.text.trim().toString()
            val imageUrl = editImageUrl.text.trim().toString()
            val isActive = editIsActive.isChecked.toString()
            val id = product.id

            var editProduct = Products(
                id = id,
                name = name,
                price = price,
                description = description,
                imageUrl = imageUrl,
                isActive = isActive
            )
            if (name.isEmpty()){
                editName.error = "Name is required"
                editName.requestFocus()
                return@setOnClickListener
            }

            if (price.isEmpty()){
                editPrice.error = "price is required"
                editPrice.requestFocus()
                return@setOnClickListener
            }

            if (description.isEmpty()){
                editDescription.error = "Description is required"
                editDescription.requestFocus()
                return@setOnClickListener
            }
            if (imageUrl.isEmpty()){
                editImageUrl.error = "ImageUrl is required"
                editImageUrl.requestFocus()
                return@setOnClickListener
            }

            ProductsApi().updateProduct(product.id,editProduct)
                .enqueue(object: Callback<Products>{
                    override fun onFailure(call: Call<Products>, t: Throwable) {
                        Toast.makeText(applicationContext, "failure "+t.message, Toast.LENGTH_LONG).show()
                    }

                    override fun onResponse(call: Call<Products>, response: Response<Products>) {
                        Log.d("responseCode", "yes ${response.code()}")
                        Log.d("responseErrorBody", "yes ${response.errorBody()}")
                        Log.d("responseBody", "yes ${response.body()}")
                        Log.d("responseHeader", "yes ${response.headers()}")
                        Log.d("responseRaw", "yes ${response.raw()}")
                        Log.d("responseBody", "yes ${response.message()}")
                        Toast.makeText(applicationContext, response.body()?.toString(), Toast.LENGTH_LONG).show()
                    }

                })
        }
    }
}