package com.example.mentalglow.view.text_analysis

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mentalglow.data.network.ApiConfig
import com.example.mentalglow.data.network.TextRequest
import com.example.mentalglow.data.response.TextClassificationResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TextViewModel : ViewModel() {

    private val _postText = MutableLiveData<TextClassificationResponse>()
    val postText: LiveData<TextClassificationResponse> = _postText

    fun postTextPrediction(request: TextRequest) {
        val client = ApiConfig.getApiService3().predictText(request)
        client.enqueue(object : Callback<TextClassificationResponse> {
            override fun onResponse(
                call: Call<TextClassificationResponse>,
                response: Response<TextClassificationResponse>
            ) {
                if (response.isSuccessful) {
                    _postText.value = response.body()
                } else {
                    Log.e(TAG, "onFailure : ${response.message()}")
                }
            }

            override fun onFailure(call: Call<TextClassificationResponse>, e: Throwable) {
                Log.e(TAG, "onFailure : ${e.message}")
            }

        })
    }

    companion object {
        private const val TAG = "TextViewModel"
    }
}