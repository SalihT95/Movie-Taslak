package com.turkoglu.composedeneme.data.remote

import com.turkoglu.composedeneme.data.remote.dto.MovieDetailDto
import com.turkoglu.composedeneme.data.remote.dto.MoviesDto
import com.turkoglu.composedeneme.util.Constants.API_KEY
import com.turkoglu.composedeneme.util.Constants.DEFAULT_PAGE
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieAPI {

    @GET("/3/movie/{movieId}")
    suspend fun getMovieDetail(
        @Path("movieId") movieId: String,
        @Query("api_key") apiKey: String = API_KEY
    ): MovieDetailDto

    @GET("/3/movie/popular")
    suspend fun getPopularMovies(
        @Query("page") page : Int =DEFAULT_PAGE,
        @Query("api_key") apiKey: String = API_KEY
    ): MoviesDto


    @GET("/3/movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("page") page : Int =DEFAULT_PAGE,
        @Query("api_key") apiKey: String = API_KEY
    ): MoviesDto

    @GET("/3/movie/now_playing")
    suspend fun getNowPlayingMovies(
        @Query("page") page : Int =DEFAULT_PAGE,
        @Query("api_key") apiKey: String = API_KEY
    ): MoviesDto

    @GET("/3/movie/upcoming")
    suspend fun getUpcomingMovies(
        @Query("page") page : Int =DEFAULT_PAGE,
        @Query("api_key") apiKey: String = API_KEY
    ): MoviesDto


    /*
      @GET(SEARCH_MOVIES)
    suspend fun getSearchMovies(
        @Query("api_key") apiKey: String,
        @Query("query") query: String
    ): MoviesModel

     */
}