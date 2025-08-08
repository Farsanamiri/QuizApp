package com.example.quizapplication

import android.os.Binder
import android.os.Bundle
import android.content.Intent
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:  ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            if (binding.usernametext.text.toString().isEmpty()) {
                Toast.makeText(this, "Enter your username", Toast.LENGTH_SHORT).show()
            } else {
                val username = binding.usernametext.text.toString()
                val intent = Intent(this, Questions::class.java)
                intent.putExtra("USERNAME", username)
                startActivity(intent)
            }
        }
    }
}