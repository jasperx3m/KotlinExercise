package com.example.kotlinexercise.Models

import com.google.gson.annotations.SerializedName
import java.io.Serializable
import com.google.gson.annotations.Expose



/*data class MoviePage (
    @SerializedName("results")
    @Expose
     var results: List<Movie>

){
    data class Movie (
        @SerializedName("overview")
        @Expose
        var overview: String,
        @SerializedName("original_language")
        @Expose
        var original_language: String,
        @SerializedName("title")
        @Expose
        var title: String,
        @SerializedName("poster_path")
        @Expose
        var poster_path: String,
        @SerializedName("release_date")
        @Expose
        var release_date: String,
        @SerializedName("vote_average")
        @Expose
        var vote_average: Double,
        @SerializedName("id")
        @Expose
        var id: Int,
        @SerializedName("vote_count")
        @Expose
        var vote_count: Int

    ) : Serializable
}*/
class MoviePage {
    var page: String? = null

    var total_pages: String? = null

    lateinit var results: MutableList<Movie>

    var total_results: String? = null
    fun getMovies(): MutableList<Movie> {
        return results
    }
    override fun toString(): String {
        return "ClassPojo [page = $page, total_pages = $total_pages, results = $results, total_results = $total_results]"
    }
}
class Movie : Serializable {
    var overview: String? = null

    var original_language: String? = null

    var original_title: String? = null

    var video: String? = null

    var title: String? = null

    var genre_ids: Array<String>? = null

    var poster_path: String? = null

    var backdrop_path: String? = null

    var release_date: String? = null

    var popularity: String? = null

    var vote_average: String? = null

    var id: String? = null

    var adult: String? = null

    var vote_count: String? = null

    override fun toString(): String {
        return "ClassPojo [overview = $overview, original_language = $original_language, original_title = $original_title, video = $video, title = $title, genre_ids = $genre_ids, poster_path = $poster_path, backdrop_path = $backdrop_path, release_date = $release_date, popularity = $popularity, vote_average = $vote_average, id = $id, adult = $adult, vote_count = $vote_count]"
    }
}