package com.turkoglu.composedeneme.presentation.home

import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.turkoglu.composedeneme.domain.use_case.get_movies.GetMovieUseCase
import com.turkoglu.composedeneme.domain.use_case.get_now_playing.GetNowPlayingUseCase
import com.turkoglu.composedeneme.domain.use_case.get_toprated.GetTopRatedUseCase
import com.turkoglu.composedeneme.domain.use_case.get_upcoming.GetUpcomingUseCase
import com.turkoglu.composedeneme.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMovieUseCase: GetMovieUseCase,
    private val getTopRatedUseCase: GetTopRatedUseCase,
    private val getNowPlayingUseCase: GetNowPlayingUseCase,
    private val getUpcomingUseCase: GetUpcomingUseCase,

) : ViewModel() {

    private val _state = mutableStateOf(HomeScreenState())
    val state: State<HomeScreenState> = _state

    private val _stateTopRated = mutableStateOf(HomeScreenStateTopRated())
    val stateTopRated: State<HomeScreenStateTopRated> = _stateTopRated

    private val _stateNowPlaying = mutableStateOf(HomeScreenStateTopRated())
    val stateNowPlaying: State<HomeScreenStateTopRated> = _stateNowPlaying

    private val _stateUpcoming = mutableStateOf(HomeScreenStateTopRated())
    val stateUpcoming: State<HomeScreenStateTopRated> = _stateUpcoming

    private val page = 1

    init {
        getMovies()
        getTopRatedMovies()
        getNowPlayingMovies()
        getUpcomingMovies()
    }

    private fun getMovies() {
        getMovieUseCase.executeGetMovies(page = page).onEach {
            when (it) {
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

    private fun getTopRatedMovies() {
        getTopRatedUseCase.executeGetTopRatedMovies(page = page).onEach {
            when (it) {
                is Resource.Success -> {
                    _stateTopRated.value = HomeScreenStateTopRated(movies = it.data ?: emptyList())
                }

                is Resource.Error -> {
                    _stateTopRated.value =
                        HomeScreenStateTopRated(errorMessage = it.message ?: "Error!")
                }

                is Resource.Loading -> {
                    _stateTopRated.value = HomeScreenStateTopRated(loading = true)
                }
            }
        }.launchIn(viewModelScope)

    }

    private fun getNowPlayingMovies() {
        getNowPlayingUseCase.executeGetNowPlayingMovies(page = page).onEach {
            when (it) {
                is Resource.Success -> {
                    _stateNowPlaying.value =
                        HomeScreenStateTopRated(movies = it.data ?: emptyList())
                }

                is Resource.Error -> {
                    _stateNowPlaying.value =
                        HomeScreenStateTopRated(errorMessage = it.message ?: "Error!")
                }

                is Resource.Loading -> {
                    _stateNowPlaying.value = HomeScreenStateTopRated(loading = true)
                }
            }
        }.launchIn(viewModelScope)

    }

    private fun getUpcomingMovies() {
        getUpcomingUseCase.executeGetUpcomingMovies(page = page).onEach {
            when (it) {
                is Resource.Success -> {
                    _stateUpcoming.value = HomeScreenStateTopRated(movies = it.data ?: emptyList())
                }

                is Resource.Error -> {
                    _stateUpcoming.value =
                        HomeScreenStateTopRated(errorMessage = it.message ?: "Error!")
                }

                is Resource.Loading -> {
                    _stateUpcoming.value = HomeScreenStateTopRated(loading = true)
                }
            }
        }.launchIn(viewModelScope)

    }

}