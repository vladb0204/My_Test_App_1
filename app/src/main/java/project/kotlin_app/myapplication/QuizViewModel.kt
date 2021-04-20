package project.kotlin_app.myapplication

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlin.math.abs

private const val TAG = "QuizModelView"

class QuizViewModel : ViewModel() {
    public var currentIndex = 0

    private val questionBank = listOf(
            Question(R.string.question_australia, true),
            Question(R.string.question_oceans, true),
            Question(R.string.question_mideast, false),
            Question(R.string.question_africa, false),
            Question(R.string.question_americas, true),
            Question(R.string.question_asia, true)
    )

    public val currentQuestionAnswer: Boolean
        get() = questionBank[abs(currentIndex)].answer

    public val currentQuestionText: Int
        get() = questionBank[abs(currentIndex)].textResId

    public fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }

    public fun moveToPrev() {
        currentIndex = (currentIndex - 1) % questionBank.size
    }
}