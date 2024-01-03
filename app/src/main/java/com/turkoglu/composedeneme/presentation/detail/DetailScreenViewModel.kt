package com.turkoglu.composedeneme.presentation.detail

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.turkoglu.composedeneme.data.remote.dto.MovieDetailDto
import com.turkoglu.composedeneme.data.repo.MovieRepositoryImpl
import com.turkoglu.composedeneme.domain.use_case.GetMovieDetailUseCase
import com.turkoglu.composedeneme.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@HiltViewModel
class DetailScreenViewModel @Inject constructor(
    private val getDetailUseCase : GetMovieDetailUseCase,
    private val savedStateHandle: SavedStateHandle
):ViewModel(){
    private val _state = mutableStateOf(DetailState())
    val state: State<DetailState> = _state


    init {
        getMovie()
    }
    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    private fun getMovie(){
        val movieId = savedStateHandle.get<String>("movieId") ?: ""
        getDetailUseCase.executeGetMovieDetail(movieId).onEach {
            when (it) {
                is Resource.Success -> {
                    _state.value= DetailState(title = it.data!!.title, overview = it.data.overview, genres = it.data.genres,
                        imdbId = it.data.imdbId, popularity = it.data.popularity, posterPath = it.data
                            .posterPath, releaseDate = it.data.releaseDate, revenue = it.data.revenue, voteAverage = it.data.voteAverage)
                }

                is Resource.Error -> {
                    println("Err")
                    //_state.value = HomeScreenState(errorMessage = it.message ?: "Error!")
                }

                is Resource.Loading -> {
                    //_state.value = HomeScreenState(loading = true)
                }
            }
        }.launchIn(viewModelScope)
    }


}