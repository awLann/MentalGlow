package com.example.mentalglow.view.image_analysis

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mentalglow.data.network.ApiConfig
import com.example.mentalglow.data.response.ImageClassificationResponse
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ImageViewModel : ViewModel() {

    private val _postImage = MutableLiveData<ImageClassificationResponse>()
    val postImage: LiveData<ImageClassificationResponse> = _postImage

    fun postImagePrediction(file: MultipartBody.Part) {
        val client = ApiConfig.getApiService2().predictImage(file)
        client.enqueue(object : Callback<ImageClassificationResponse> {
            override fun onResponse(
                call: Call<ImageClassificationResponse>,
                response: Response<ImageClassificationResponse>
            ) {
                if (response.isSuccessful) {
                    _postImage.value = response.body()
                } else {
                    Log.e(TAG, "onFailure : ${response.message()}")
                }
            }

            override fun onFailure(call: Call<ImageClassificationResponse>, e: Throwable) {
                Log.e(TAG, "onFailure : ${e.message}")
            }

        })
    }

    companion object {
        private const val TAG = "ImageViewModel"
    }
}