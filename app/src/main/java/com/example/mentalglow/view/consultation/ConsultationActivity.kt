package com.example.mentalglow.view.consultation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mentalglow.databinding.ActivityConsultationBinding
import com.example.mentalglow.view.home.HomeActivity
import com.example.mentalglow.view.maps.MapsActivity

class ConsultationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConsultationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConsultationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btnYes.setOnClickListener {
            startActivity(Intent(this, MapsActivity::class.java))
        }
        binding.btnNo.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finishAffinity()
        }
    }
}