package com.example.kotlinexercise.Repositories


import androidx.annotation.NonNull
import com.example.kotlinexercise.API.OnGetMoviesCallback
import com.example.kotlinexercise.API.TMDbApi
import com.example.kotlinexercise.Models.MoviePage
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit


class MoviesRepository private constructor(private val api: TMDbApi) {

    fun getMovies(callback: OnGetMoviesCallback) {
        api.getPopularMovies("api_key=02c8a58b1ad65bb77e82cfb472a2ab86", LANGUAGE, 1)
            .enqueue(object : Callback<MoviePage>  {
                override fun onResponse(call: Call<MoviePage>, response: Response<MoviePage>) {
                    if (response.isSuccessful) {
                        val moviesResponse  = response.body()
                        if (moviesResponse != null && moviesResponse!!.getMovies() != null) {
                            callback.onSuccess(moviesResponse!!.getMovies())
                        } else {
                            callback.onError()
                        }
                    } else {
                        callback.onError()
                    }
                }

                override fun onFailure(call: Call<MoviePage>, t: Throwable) {
                    callback.onError()
                }
            })
    }

    companion object {

        private val BASE_URL = "https://api.themoviedb.org/3/"
        private val LANGUAGE = "en-US"
        private var repository: MoviesRepository? = null

        val instance: MoviesRepository
            get() {
                if (repository == null) {
                    val retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()

                    repository = MoviesRepository(retrofit.create(TMDbApi::class.java))
                }
                return repository!!
            }
    }
}