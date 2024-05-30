package com.example.mentalglow.view.signin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mentalglow.databinding.ActivitySigninBinding
import com.example.mentalglow.view.home.MainActivity

class SigninActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySigninBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.btnSignin.setOnClickListener {
            val intent = Intent(this@SigninActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}