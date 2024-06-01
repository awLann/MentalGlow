package com.example.mentalglow.view.home.fragment.text

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TextAnalysisViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is text analysis Fragment"
    }
    val text: LiveData<String> = _text
}