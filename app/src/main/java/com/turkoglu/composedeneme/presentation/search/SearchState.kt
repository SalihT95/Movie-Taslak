package com.turkoglu.composedeneme.presentation.search

import com.turkoglu.composedeneme.data.remote.SingleMovie

data class SearchState (
    val isLoading : Boolean = false,
    val movies : List<SingleMovie> = emptyList(),
    val error  : String = "",
    val search : String = "Star Wars"
)