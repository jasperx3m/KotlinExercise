package com.example.kotlinexercise

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinexercise.API.ProductsApi
import com.example.kotlinexercise.Adapters.ProductsAdapter
import com.example.kotlinexercise.Models.Products
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_products.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductsActivity : AppCompatActivity(), ProductsAdapter.OnProductClickListener {


    lateinit var productList: MutableList<Products>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
        fetchProducts()
        productRefreshLayout.setOnRefreshListener{
            fetchProducts()
        }

        addProductsButton.setOnClickListener{
            var intent = Intent(this, ProductForm::class.java)
            startActivity(intent)
        }
    }
    private fun fetchProducts(){
        ProductsApi().getProducts().enqueue(object: Callback<MutableList<Products>>{
            override fun onFailure(call: Call<MutableList<Products>>, t: Throwable){
                Toast.makeText(applicationContext,t.message, Toast.LENGTH_LONG).show()
            }
            override fun onResponse(call:Call<MutableList<Products>>, response : Response<MutableList<Products>>){
                val products = response.body()
                products?.let { showProducts(it) }
            }
        })
    }

    private fun showProducts(products: MutableList<Products>) {
        productList = products
        productRecyclerView.layoutManager = LinearLayoutManager(this)
        productRecyclerView.adapter = ProductsAdapter(productList, this,this)
        ItemTouchHelper(SwipeToDeleteCallBack()).attachToRecyclerView(productRecyclerView)
        productRefreshLayout.isRefreshing=(false)

    }

    override fun onProductClick(position: Int){

        var intent= Intent(this,ProductDetails::class.java)
        startActivity(intent.putExtra("movie",productList[position]))
    }

    override fun onProductLongClick(position: Int) {
        var intent = Intent(this,ProductEditForm::class.java)
        startActivity(intent.putExtra("movie",productList[position]))
    }

    private fun deleteProduct(position: Int){
        var temporaryProduct = productList[position]
        var isUndone: Boolean = false
        productList.removeAt(position)
        showProducts(productList)
        var snackbar = Snackbar.make(
            productLayoutConstraint,
            " ${productList[position].name} Deleted",
            Snackbar.LENGTH_LONG
        )
        snackbar.setAction("UNDO") {
            isUndone = true
            if (isUndone) {
                productList.add(position, temporaryProduct)
                Toast.makeText(
                    this, "${
                    productList[position].name} has been restored", Toast.LENGTH_SHORT
                ).show()
                showProducts(productList)
            }
        }

            if (!isUndone) {
                ProductsApi().deleteProduct(temporaryProduct.id)
                    .enqueue(object : Callback<Products> {
                        override fun onFailure(call: Call<Products>, t: Throwable) {
                            Toast.makeText(applicationContext, "failure " + t.message, Toast.LENGTH_LONG).show()
                        }

                        override fun onResponse(call: Call<Products>, response: Response<Products>) {
                            Toast.makeText(applicationContext, response.body()?.toString(), Toast.LENGTH_LONG).show()
                        }
                    })
                snackbar.show()
            }
    }

    inner  class SwipeToDeleteCallBack : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT){
        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
            return false
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            deleteProduct(viewHolder.adapterPosition)

        }
    }

}