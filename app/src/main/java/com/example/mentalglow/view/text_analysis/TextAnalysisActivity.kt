package com.example.mentalglow.view.text_analysis

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mentalglow.databinding.ActivityTextAnalysisBinding
import com.example.mentalglow.helper.TextClassifierHelper
import com.google.mediapipe.tasks.components.containers.Classifications
import java.text.NumberFormat

class TextAnalysisActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTextAnalysisBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTextAnalysisBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val textClassifierHelper = TextClassifierHelper(
//            context = this,
//            classifierListener = object : TextClassifierHelper.ClassifierListener {
//                override fun onError(error: String) {
//                    Toast.makeText(this@TextAnalysisActivity, error, Toast.LENGTH_SHORT).show()
//                }
//
//                override fun onResults(results: List<Classifications>?, inferenceTime: Long) {
//                    runOnUiThread {
//                        results?.let { it ->
//                            if (it.isNotEmpty() && it[0].categories().isNotEmpty()) {
//                                println(it)
//                                val sortedCategories =
//                                    it[0].categories().sortedByDescending { it?.score() }
//
//                                val displayResult =
//                                    sortedCategories.joinToString("\n") {
//                                        "${it.categoryName()} " + NumberFormat.getPercentInstance()
//                                            .format(it.score()).trim()
//                                    }
//                                binding.tvResult.text = displayResult
//                            } else {
//                                binding.tvResult.text = ""
//                            }
//                        }
//                    }
//                }
//            }
//        )
//
//        binding.btnClassify.setOnClickListener {
//            val inputText = binding.edInput.text.toString()
//            textClassifierHelper.classify(inputText)
//        }
    }
}