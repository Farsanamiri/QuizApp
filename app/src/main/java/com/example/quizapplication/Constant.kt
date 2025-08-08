package com.example.quizapplication

class Constant {
    companion object{
        fun getQuestions(): ArrayList<Question> {
            var questionList = ArrayList<Question>()

            val question1 = Question(
                1, "Which country has this flag ?", R.drawable.ic_flag_of_argentina,
                "IRAN", "UAE", "USA", "ARGENTINA", 4
            )

            val question2 = Question(
                2, "Which country has this flag ?", R.drawable.ic_flag_of_brazil,
                "USA", "BRAZIL", "OMAN", "ARGENTINA", 2
            )

            val question3 = Question(
                3, "Which country has this flag ?", R.drawable.ic_flag_of_india,
                "FRANCE", "DENMARK", "TURKEY", "INDIA", 4
            )

            val question4 = Question(
                4, "Which country has this flag ?", R.drawable.ic_flag_of_germany,
                "IRAN", "GERMANY", "TURKEY", "ARGENTINA", 2
            )

            val question5 = Question(
                5, "Which country has this flag ?", R.drawable.ic_flag_of_denmark,
                "IRAN", "DENMARK", "TURKEY", "ARGENTINA", 2
            )

            val question6 = Question(
                6, "Which country has this flag ?", R.drawable.ic_flag_of_new_zealand,
                "NEW ZEALAND", "DENMARK", "TURKEY", "ARGENTINA", 1
            )

            val question7 = Question(
                7, "Which country has this flag ?", R.drawable.ic_flag_of_kuwait,
                "IRAN", "DENMARK", "KUWAIT", "ARGENTINA", 3
            )
            questionList.add(question1)
            questionList.add(question2)
            questionList.add(question3)
            questionList.add(question4)
            questionList.add(question5)
            questionList.add(question6)
            questionList.add(question7)
            return questionList

        }
    }
}