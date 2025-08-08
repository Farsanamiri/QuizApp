package com.example.quizapplication

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.quizapplication.databinding.ActivityQuestionsBinding

class Questions : AppCompatActivity() {

    lateinit var binding: ActivityQuestionsBinding
    var currentIndex = 0
    var selectedOptionUser = 0
    lateinit var questionList: ArrayList<Question>
    var wrongAnswers = 0
    var correctAnswers = 0
    lateinit var username: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // دریافت نام کاربر از MainActivity
        username = intent.getStringExtra("USERNAME") ?: ""

        questionList = Constant.getQuestions()
        loadQuestionData()

        binding.button2.setOnClickListener {
            submitAnswer()
        }

        binding.tov1.setOnClickListener { optionClick(it) }
        binding.tov2.setOnClickListener { optionClick(it) }
        binding.tov3.setOnClickListener { optionClick(it) }
        binding.tov4.setOnClickListener { optionClick(it) }
    }

    private fun resetOptionStyles() {
        val options = arrayListOf(binding.tov1, binding.tov2, binding.tov3, binding.tov4)
        for (txt in options) {
            txt.typeface = Typeface.DEFAULT
            txt.background = ContextCompat.getDrawable(this, R.drawable.option_background)
            txt.setTextColor(Color.parseColor("#7a8089"))
        }
    }

    private fun loadQuestionData() {
        if (currentIndex >= questionList.size) {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("CORRECT", correctAnswers)
            intent.putExtra("WRONG", wrongAnswers)
            intent.putExtra("TOTAL", questionList.size)
            intent.putExtra("USERNAME", username)
            startActivity(intent)
            finish()
            return
        }

        val question = questionList[currentIndex]
        binding.textView6.text = question.question
        binding.imageView.setImageResource(question.image)
        binding.tov1.text = question.optionone
        binding.tov2.text = question.optiontwo
        binding.tov3.text = question.optionthree
        binding.tov4.text = question.optionfour
        binding.progressBar.progress = currentIndex + 1
        binding.protw.text = "${currentIndex + 1} / ${binding.progressBar.max}"

        resetOptionStyles()
        selectedOptionUser = 0
    }

    private fun optionClick(view: View) {
        resetOptionStyles()
        val selectedTextView = view as TextView

        selectedOptionUser = when (selectedTextView.id) {
            binding.tov1.id -> 1
            binding.tov2.id -> 2
            binding.tov3.id -> 3
            binding.tov4.id -> 4
            else -> 0
        }

        selectedTextView.typeface = Typeface.DEFAULT_BOLD
        selectedTextView.background = ContextCompat.getDrawable(this, R.drawable.option_background_selected)
        selectedTextView.setTextColor(Color.parseColor("#000000"))
    }

    private fun submitAnswer() {
        if (selectedOptionUser == 0) {
            Toast.makeText(this, "Please select an option", Toast.LENGTH_SHORT).show()
        } else {
            val currentQuestion = questionList[currentIndex]
            if (selectedOptionUser == currentQuestion.CorrectOption) {
                highlightOption(selectedOptionUser, R.drawable.options_background_correct)
                correctAnswers++
            } else {
                highlightOption(selectedOptionUser, R.drawable.options_background_wrong)
                highlightOption(currentQuestion.CorrectOption, R.drawable.options_background_correct)
                wrongAnswers++
            }

            binding.root.postDelayed({
                currentIndex++
                loadQuestionData()
            }, 1500)
        }
    }

    private fun highlightOption(optionIndex: Int, drawableId: Int) {
        when (optionIndex) {
            1 -> binding.tov1.background = ContextCompat.getDrawable(this, drawableId)
            2 -> binding.tov2.background = ContextCompat.getDrawable(this, drawableId)
            3 -> binding.tov3.background = ContextCompat.getDrawable(this, drawableId)
            4 -> binding.tov4.background = ContextCompat.getDrawable(this, drawableId)
        }
    }
}
