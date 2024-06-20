package com.example.mentalglow.view.text_analysis

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mentalglow.databinding.ActivityTextAnalysisBinding

class TextAnalysisActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTextAnalysisBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTextAnalysisBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}