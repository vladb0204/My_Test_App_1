package project.kotlin_app.myapplication

import androidx.annotation.StringRes

data class Question(@StringRes val textResId: Int, val answer: Boolean) {
    
}