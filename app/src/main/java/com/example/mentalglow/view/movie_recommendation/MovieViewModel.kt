package com.example.mentalglow.view.movie_recommendation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mentalglow.data.network.ApiConfig
import com.example.mentalglow.data.response.MovieResponse
import com.example.mentalglow.data.response.MovieResponseItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _listMovie = MutableLiveData<List<MovieResponseItem>>()
    val listMovie: LiveData<List<MovieResponseItem>> = _listMovie

    init {
        findMovie("angry")
    }

    fun findMovie(query: String) {
        _isLoading.value = true
        val client = ApiConfig.getApiService().getMovies(query)
        client.enqueue(object : Callback<List<MovieResponseItem>> {
            override fun onResponse(call: Call<List<MovieResponseItem>>, response: Response<List<MovieResponseItem>>) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        _listMovie.value = response.body()
                    }
                } else {
                    Log.e(TAG, "onFailure : ${response.message()}")
                }
            }

            override fun onFailure(call: Call<List<MovieResponseItem>>, e: Throwable) {
                _isLoading.value = true
                Log.e(TAG, "onFailure : ${e.message}")
            }
        })
    }

    companion object {
        private const val TAG = "MovieViewModel"
    }
}