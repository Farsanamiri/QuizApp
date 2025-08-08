package com.example.quizapplication

import android.os.Bundle
import android.graphics.Color
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.quizapplication.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var correct = intent.getIntExtra("CORRECT", 0)
        var wrong = intent.getIntExtra("WRONG", 0)
        val username = intent.getStringExtra("USERNAME") ?: "Unknown"
        val total = intent.getIntExtra("TOTAL", 0)
        val newwrong = wrong.toInt()/3
        newwrong.toInt()
        correct = wrong-newwrong

        binding.textView.text = username
        if (correct.toInt() > wrong.toInt()){
            binding.textView.setTextColor(Color.parseColor("#37eb34"))
        }
        else{
            binding.textView.setTextColor(Color.parseColor("#e32b2b"))
        }
        binding.textView8.text = "$wrong Wrong Answers"
        binding.textView7.text = "$correct Correct Answers"

        if(total == correct.toInt()){
            binding.imageView2.visibility = View.VISIBLE
            binding.textView7.visibility = View.INVISIBLE
            binding.textView8.visibility = View.INVISIBLE
        }
    }
}
