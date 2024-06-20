package com.example.mentalglow.view.image_analysis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mentalglow.databinding.ActivityImageResultBinding
import com.example.mentalglow.view.movie_recommendation.MovieRecommendationActivity

class ImageResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImageResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        // Get the data from the intent
        val probability = intent.getDoubleExtra(EXTRA_PROBABILITY, 0.0)
        val classLabel = intent.getStringExtra(EXTRA_CLASS)

        // Display the data
        binding.tvProbability.text = "$probability"
        binding.tvClass.text = "$classLabel"

        binding.btnNext.setOnClickListener {
            val intent = Intent(this, MovieRecommendationActivity::class.java).apply {
                putExtra(MovieRecommendationActivity.EXTRA_CLASS, classLabel)
            }
            startActivity(intent)
        }
    }

    companion object {
        const val EXTRA_PROBABILITY = "extra_probability"
        const val EXTRA_CLASS = "extra_class"
    }
}