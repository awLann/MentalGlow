package com.example.mentalglow.view.text_analysis

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mentalglow.databinding.ActivityTextResultBinding
import com.example.mentalglow.view.consultation.ConsultationActivity

class TextResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTextResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTextResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        val result = intent.getStringExtra(EXTRA_RESULT)
        val keterangan = intent.getStringExtra(EXTRA_KETERANGAN)
        val presentase = intent.getStringExtra(EXTRA_PRESENTASE)

        binding.tvResult.text = result
        binding.tvDesc.text = keterangan
        binding.tvPercentage.text = presentase

        binding.btnNext.setOnClickListener {
            startActivity(Intent(this, ConsultationActivity::class.java))
        }
    }

    companion object {
        const val EXTRA_RESULT = "extra_result"
        const val EXTRA_KETERANGAN = "extra_keterangan"
        const val EXTRA_PRESENTASE = "extra_presentase"
    }
}