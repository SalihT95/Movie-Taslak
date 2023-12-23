package com.turkoglu.composedeneme.data.remote

import com.turkoglu.composedeneme.data.remote.dto.MovieDetailDto
import com.turkoglu.composedeneme.data.remote.dto.MoviesDto
import com.turkoglu.composedeneme.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieAPI {

    companion object{
        const val POPULAR_MOVIES = "/3/movie/popular"
        const val SEARCH_MOVIES = "3/search/movie"
        const val MOVIE_DETAIL = "/3/movie/{movieId}"
    }
    @GET(POPULAR_MOVIES)
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = API_KEY
    ): MoviesDto

    @GET(MOVIE_DETAIL)
    suspend fun getMovieDetail(
        @Path("movieId") movieId: String,
        @Query("api_key") apiKey: String = API_KEY
    ): MovieDetailDto

    /*
      @GET(SEARCH_MOVIES)
    suspend fun getSearchMovies(
        @Query("api_key") apiKey: String,
        @Query("query") query: String
    ): MoviesModel

     */
}