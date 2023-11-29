package com.turkoglu.composedeneme.data.remote

import com.google.gson.annotations.SerializedName

data class SingleMovie(
    val id: Int?,
    val overview: String?,
    //val popularity: Double?,
    @SerializedName("poster_path")
    val posterImage: String?,
    @SerializedName("release_date")
    val releaseDate: String?,
    val title: String?
)