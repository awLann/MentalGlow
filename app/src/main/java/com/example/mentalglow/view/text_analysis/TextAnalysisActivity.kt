package com.example.mentalglow.view.text_analysis

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.mentalglow.data.network.TextRequest
import com.example.mentalglow.databinding.ActivityTextAnalysisBinding

class TextAnalysisActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTextAnalysisBinding
    private val viewModel by viewModels<TextViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTextAnalysisBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btnAnalyze.setOnClickListener {
            val inputText = binding.edtText.text.toString()
            viewModel.postTextPrediction(TextRequest(inputText))
        }

        viewModel.postText.observe(this) { response ->
            // Start TextResultActivity with the response data
            if (response != null) {
                val intent = Intent(this, TextResultActivity::class.java).apply {
                    putExtra(TextResultActivity.EXTRA_RESULT, response.result)
                    putExtra(TextResultActivity.EXTRA_KETERANGAN, response.keterangan)
                    putExtra(TextResultActivity.EXTRA_PRESENTASE, response.presentase)
                }
                startActivity(intent)
            }
        }
    }
}