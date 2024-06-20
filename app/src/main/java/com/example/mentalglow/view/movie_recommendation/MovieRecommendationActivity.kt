package com.example.mentalglow.view.movie_recommendation

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mentalglow.adapter.ListMovieAdapter
import com.example.mentalglow.databinding.ActivityMovieRecommendationBinding
import java.util.Locale

class MovieRecommendationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieRecommendationBinding
    private val viewModel by viewModels<MovieViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieRecommendationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        showRecyclerList()

        viewModel.isLoading.observe(this) {
            showLoading(it)
        }

        val classLabel = intent.getStringExtra(EXTRA_CLASS)
        if (classLabel != null) {
            setMood(classLabel)
        }
    }

    private fun setMood(mood: String) {
        viewModel.findMovie(mood.lowercase(Locale.getDefault()))
    }

    private fun showRecyclerList() {
        val layoutManager = LinearLayoutManager(this)
        binding.rvMovie.layoutManager = layoutManager

        val itemMovie = DividerItemDecoration(this, layoutManager.orientation)
        binding.rvMovie.addItemDecoration(itemMovie)

        binding.rvMovie.setHasFixedSize(true)

        viewModel.listMovie.observe(this) { adapter ->
            if (adapter != null) {
                binding.rvMovie.adapter = ListMovieAdapter(adapter)
            }
        }
    }

    private fun showLoading(isLoading: Boolean) {
        if (isLoading) {
            binding.progressBar.visibility = View.VISIBLE
        } else {
            binding.progressBar.visibility = View.GONE
        }
    }

    companion object {
        const val EXTRA_CLASS = "extra_class"
    }
}