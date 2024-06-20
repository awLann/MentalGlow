package com.example.mentalglow.view.home

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.credentials.ClearCredentialStateRequest
import androidx.credentials.CredentialManager
import androidx.lifecycle.lifecycleScope
import com.example.mentalglow.R
import com.example.mentalglow.databinding.ActivityHomeBinding
import com.example.mentalglow.view.image_analysis.ImageAnalysisActivity
import com.example.mentalglow.view.signin.SigninActivity
import com.example.mentalglow.view.text_analysis.TextAnalysisActivity
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import kotlinx.coroutines.launch

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth
        val firebaseUser = auth.currentUser
        if (firebaseUser == null) {
            startActivity(Intent(this, SigninActivity::class.java))
            finish()
            return
        }

        binding.btnCheckImage.setOnClickListener {
            startActivity(Intent(this, ImageAnalysisActivity::class.java))
        }
        binding.btnCheckText.setOnClickListener {
            startActivity(Intent(this, TextAnalysisActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.signout -> {
                showAlertDialog()
                return true
            }
            else -> return true
        }
    }

    private fun showAlertDialog() {
        val builder = AlertDialog.Builder(this@HomeActivity)
        builder.setTitle("Logout")
        builder.setMessage("Are you sure you wan to logout?")

        builder.setPositiveButton("Yes") {dialog, which ->
            dialog.dismiss()
            signOut()
        }
        builder.setNegativeButton("No") {dialog, which ->
            dialog.dismiss()
        }
        val dialog = builder.create()
        dialog.show()
    }

    private fun signOut() {
        lifecycleScope.launch {
            val credentialManager = CredentialManager.create(this@HomeActivity)
            auth.signOut()
            credentialManager.clearCredentialState(ClearCredentialStateRequest())
            startActivity(Intent(this@HomeActivity, SigninActivity::class.java))
            finish()
        }
    }
}