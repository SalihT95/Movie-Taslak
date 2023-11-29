package com.turkoglu.composedeneme.presentation.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.turkoglu.composedeneme.data.remote.APIClient
import com.turkoglu.composedeneme.data.remote.SingleMovie
import com.turkoglu.composedeneme.util.Constants
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    val movieList: MutableLiveData<List<SingleMovie?>?> = MutableLiveData()
    val isLoading = MutableLiveData(false)
    val errorMessage: MutableLiveData<String?> = MutableLiveData()

    init {
        getMovieList()
    }

    fun getMovieList() {
        isLoading.value = true

        viewModelScope.launch {
            try {
                val response = APIClient.getClient().getMovieList(token = Constants.BEARER_TOKEN)

                if (response.isSuccessful) {
                    movieList.postValue(response.body()?.results)
                } else {
                    if (response.message().isNullOrEmpty()) {
                        errorMessage.value = "An unknown error occurred"
                    } else {
                        errorMessage.value = response.message()
                    }
                }
            } catch (e: Exception) {
                errorMessage.value = e.message
            }
            finally {
                isLoading.value = false
            }
        }
    }

}