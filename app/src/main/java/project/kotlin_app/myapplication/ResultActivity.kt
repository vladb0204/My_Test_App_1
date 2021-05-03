package project.kotlin_app.myapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders

class ResultActivity : AppCompatActivity() {

    private lateinit var restartButton: Button
    private lateinit var resultTextView: TextView
    private lateinit var resultVerdictTextView: TextView

    private val quizViewModel: QuizViewModel by lazy {
        ViewModelProviders.of(this).get(QuizViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        restartButton = findViewById(R.id.restart_button)
        resultTextView = findViewById(R.id.result_textview)

        setResultText()
        setResultVerdict()

        restartButton.setOnClickListener {
            val intent = MainActivity.newIntent(this@ResultActivity)
            startActivityForResult(intent, 0)
        }
    }

    public fun setResultText() {
        val result: String = when (CHEATING_BOOLEAN) {
            true -> (quizViewModel.getCorrectAnswersCount()).toString() + "/" + (quizViewModel.getQuestionBankSize()).toString()
            false -> "Sorry, But we know that you were cheating during the test!"
        }
        resultTextView.setText(result)
    }

    private fun setResultVerdict() {
        val resultsList = listOf("Bad", "Not good", "Good!", "Well!", "Really Well!", "Great!", "Excellent!")
        resultVerdictTextView.setText(resultsList[quizViewModel.getCorrectAnswersCount()])
    }

    companion object {
        public fun newIntent(packageContext: Context, answerIsTrue: Boolean): Intent {
            return Intent(packageContext, ResultActivity::class.java).apply {
                putExtra("project.kotlin_app.myapplication.answer_is_true", answerIsTrue)
            }
        }
    }
}