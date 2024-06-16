package com.example.mentalglow.data.network

import com.example.mentalglow.data.response.MovieResponse
import com.example.mentalglow.data.response.MovieResponseItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("{mood}")
    fun getMovies(
        @Path("mood") mood: String
    ): Call<List<MovieResponseItem>>
}