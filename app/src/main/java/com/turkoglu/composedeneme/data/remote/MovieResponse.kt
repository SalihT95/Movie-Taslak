package com.turkoglu.composedeneme.data.remote

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    //val page: Int?,
    val results: List<SingleMovie?>?
    //@SerializedName("total_pages")
    //val totalPages: Int?
)