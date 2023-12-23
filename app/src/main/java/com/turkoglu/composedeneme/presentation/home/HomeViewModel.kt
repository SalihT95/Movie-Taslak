package com.turkoglu.composedeneme.presentation.home

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.turkoglu.composedeneme.domain.use_case.get_movies.GetMovieUseCase
import com.turkoglu.composedeneme.domain.use_case.get_toprated.GetTopRatedUseCase
import com.turkoglu.composedeneme.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMovieUseCase: GetMovieUseCase,
    private val getTopRatedUseCase: GetTopRatedUseCase
): ViewModel() {

    val _state = mutableStateOf(HomeScreenState())
    val state : State<HomeScreenState> =_state
    private val page  = 1

    init {
        getMovies()
    }

    private fun getMovies(){
        getMovieUseCase.executeGetMovies(page = page).onEach {
            when(it){
               is Resource.Success -> {
                   _state.value = HomeScreenState(movies = it.data ?: emptyList())
               }
                is Resource.Error -> {
                    _state.value = HomeScreenState(errorMessage = it.message ?: "Error!")
               }
                is Resource.Loading -> {
                    _state.value = HomeScreenState(loading = true)
                }
            }
        }.launchIn(viewModelScope)

    }


}