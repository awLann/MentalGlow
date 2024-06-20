package com.example.mentalglow.data.network

import com.example.mentalglow.data.response.ImageClassificationResponse
import com.example.mentalglow.data.response.MovieResponseItem
import com.example.mentalglow.data.response.TextClassificationResponse
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part
import retrofit2.http.Path

interface ApiService {
    @GET("{mood}")
    fun getMovies(
        @Path("mood") mood: String
    ): Call<List<MovieResponseItem>>
}

interface ApiService2 {
    @Multipart
    @POST("face-detection/predict")
    fun predictImage(
        @Part file: MultipartBody.Part
    ): Call<ImageClassificationResponse>
}

interface ApiService3 {
    @Headers("Content-Type: application/json")
    @POST("predict")
    fun predictText(
        @Body request: TextRequest
    ): Call<TextClassificationResponse>
}

data class TextRequest(
    val text: String
)
