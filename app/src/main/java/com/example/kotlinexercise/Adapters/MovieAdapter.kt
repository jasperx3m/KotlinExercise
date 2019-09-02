package com.example.kotlinexercise.Adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.kotlinexercise.Models.Movie



import com.example.kotlinexercise.R
import kotlinx.android.synthetic.main.activity_contact_details.*
import kotlinx.android.synthetic.main.layout_movie.view.*

class MovieAdapter (private var movies: List<Movie>, var context: Context, private var onClickListener: MovieAdapter.OnClickListener) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_movie,parent,false)
            ,onClickListener)
    }
    override fun getItemCount()=movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.itemView.movieTitle.text = movie.title
        holder.itemView.rate.text= movie.vote_average.toString()
        var circularProgressDrawable = CircularProgressDrawable(context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()
        Glide.with(context)
            .load("https://image.tmdb.org/t/p/original${movie.backdrop_path}")
            .placeholder(circularProgressDrawable)
            .into(holder.itemView.movieImage)
    }

    class MovieViewHolder(itemView: View, var onClickListener: MovieAdapter.OnClickListener) : RecyclerView.ViewHolder(itemView)
        , View.OnClickListener
        , View.OnLongClickListener{

        init {
            itemView.setOnClickListener(this)
            itemView.setOnLongClickListener(this)
        }
        override fun onClick(view: View) {
            onClickListener.onMovieClick(adapterPosition)
        }
        override fun onLongClick(view: View): Boolean {
            onClickListener.onMovieLongClick(adapterPosition)
            return true
        }

    }
    interface OnClickListener{
        fun onMovieClick(position: Int)
        fun onMovieLongClick(position: Int)
    }
}