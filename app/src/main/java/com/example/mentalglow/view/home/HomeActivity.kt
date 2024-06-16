package com.example.mentalglow.view.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mentalglow.R
import com.example.mentalglow.databinding.ActivityHomeBinding
import com.example.mentalglow.view.movie_recommendation.MovieRecommendationActivity

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCheck.setOnClickListener {
            val intent = Intent(this, MovieRecommendationActivity::class.java)
            startActivity(intent)
        }
    }
}