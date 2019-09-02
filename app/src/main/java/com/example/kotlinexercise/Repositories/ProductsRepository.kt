/*
package com.example.kotlinexercise.Repositories
import com.example.kotlinexercise.API.OnGetProductsCallback
import com.example.kotlinexercise.API.ProductsApi
import com.example.kotlinexercise.Models.Products
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit


class ProductsRepository private constructor(private val api: ProductsApi) {

    fun getMovies(callback: OnGetProductsCallback) {
        api.getProducts()
            .enqueue(object : Callback<MutableList<Products>>  {
                override fun onResponse(call: Call<MutableList<Products>>, response: Response<MutableList<Products>>) {
                    if (response.isSuccessful) {
                        val products  = response.body()
                        products?.let{
                            callback.onSuccess(products)
                        }
                    } else {
                        callback.onError()
                    }
                }

                override fun onFailure(call: Call<MutableList<Products>>, t: Throwable) {
                    callback.onError()
                }
            })
    }

    companion object {

        private val BASE_URL = "https://localhost:5001/api/"
         lateinit var repository: ProductsRepository

        val instance: ProductsRepository
            get() {
                if (repository == null) {
                    val retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()

                    repository = ProductsRepository(retrofit.create(ProductsApi::class.java))
                }
                return repository!!
            }
    }
}*/
