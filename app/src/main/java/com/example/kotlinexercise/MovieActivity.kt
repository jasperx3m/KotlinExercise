package com.example.kotlinexercise

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log.d
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinexercise.API.OnGetMoviesCallback
import com.example.kotlinexercise.Adapters.MovieAdapter
import com.example.kotlinexercise.Models.Movie
import com.example.kotlinexercise.Models.MoviePage

import com.example.kotlinexercise.Repositories.MoviesRepository
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_contacts.*
import kotlinx.android.synthetic.main.activity_movies.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieActivity : AppCompatActivity(), MovieAdapter.OnClickListener {

    private lateinit var moviesRepository : MoviesRepository

    lateinit var movieList: MutableList<Movie>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)
        moviesRepository = MoviesRepository.instance
        fetchMovies()
        refreshLayout.setOnRefreshListener{
            fetchMovies()
        }
        addMovieButton.setOnClickListener{
            var intent = Intent(this, MovieForm::class.java)
            startActivity(intent)
        }
    }

    private fun fetchMovies(){
        refreshLayout.isRefreshing = true
        val handler = object: OnGetMoviesCallback{
            override fun onError() {
            }
            override fun onSuccess(movies: MutableList<Movie>) {
                showMovies(movies)
            }
        }
        moviesRepository.getMovies(handler)
    }

    private fun showMovies(movies: MutableList<Movie>) {
        movieList = movies
        movieRecyclerView.layoutManager = LinearLayoutManager(this)
        movieRecyclerView.adapter = MovieAdapter(movieList, this,this)
        ItemTouchHelper(SwipeToDeleteCallBack()).attachToRecyclerView(movieRecyclerView)
        refreshLayout.isRefreshing=(false)

    }

    override fun onMovieClick(position: Int){

        var intent= Intent(this,MovieDetails::class.java)

        startActivity(intent.putExtra("movie",movieList[position]))
    }

    override fun onMovieLongClick(position: Int) {
        deleteMovie(position)
    }

    private fun deleteMovie(position: Int){
        var temporaryMovie = movieList[position]
        movieList.removeAt(position)
        showMovies(movieList)
        var snackbar=Snackbar.make(layoutConstraint," ${movieList[position].title} Deleted", Snackbar.LENGTH_LONG)
        snackbar.setAction("UNDO") {
        undoDelete(position,temporaryMovie)
    }
        snackbar.show()
    }
    private fun undoDelete(position: Int, temporaryMovie: Movie){
        movieList.add(position,temporaryMovie)
        Toast.makeText(this,"${
        movieList[position].title} has been restored", Toast.LENGTH_SHORT).show()
        showMovies(movieList)
    }
    inner  class SwipeToDeleteCallBack : ItemTouchHelper.SimpleCallback(0,
        ItemTouchHelper.RIGHT
    ){
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return false
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            deleteMovie(viewHolder.adapterPosition)
        }
    }
}