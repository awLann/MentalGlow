package com.example.mentalglow.view.home.fragment.image

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ImageAnalysisViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is image analysis Fragment"
    }
    val text: LiveData<String> = _text
}