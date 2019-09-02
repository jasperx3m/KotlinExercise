package com.example.kotlinexercise

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.kotlinexercise.Models.Movie
import kotlinx.android.synthetic.main.activity_contact_details.*
import kotlinx.android.synthetic.main.activity_movie_details.*
const val BASE_URL ="https://image.tmdb.org/t/p/original"
class MovieDetails : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        val movie = intent.getSerializableExtra("movie") as Movie
        movieDate.text = movie.release_date
        movieTitle.text = movie.title
        movieRate.text = movie.vote_average
        movieLikes.text = movie.vote_count
        movieSummary.text = movie.overview

        getImage(BASE_URL+movie.poster_path,moviePoster)
        getImage(BASE_URL+movie.backdrop_path,movieBackdrop)
    }
    private fun getImage(url: String, imagePath: ImageView){
        var circularProgressDrawable = CircularProgressDrawable(this)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()
        Glide.with(this)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(true)
            .placeholder(circularProgressDrawable)
            .into(imagePath)
    }
}