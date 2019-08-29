package com.example.kotlinexercise.API

import android.util.Log

import com.example.kotlinexercise.Models.MyPojo
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
//"02c8a58b1ad65bb77e82cfb472a2ab86"
const val API_KEY = "discover/movie?page=1&include_video=false&include_adult=false&sort_by=popularity.desc&language=en-US&api_key=02c8a58b1ad65bb77e82cfb472a2ab86"
const val BASE_URL="http://api.themoviedb.org/3/"
interface MoviesApi {
    @GET("discover/movie?&api_key=02c8a58b1ad65bb77e82cfb472a2ab86")
    fun getMovies() : Call<List<MyPojo>>
    companion object{
        operator fun invoke() : MoviesApi{
            Log.d("TAG", "yeah yeah")
            val retrofit=Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MoviesApi::class.java)
            Log.d("TAG", Gson().toJson(retrofit).toString() + "yeahyeah")
            return retrofit
        }
    }
}