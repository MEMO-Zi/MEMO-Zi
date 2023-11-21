package com.memo_zi.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.text.set
import androidx.core.text.toSpannable
import com.memo_zi.R
import com.memo_zi.util.text.LinearGradientSpan

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val txtHello: TextView = findViewById(R.id.logoText)
        val text = TITLE_TEXT
        val startColorInt = ContextCompat.getColor(this, R.color.bg_start)
        val endColorInt = ContextCompat.getColor(this, R.color.bg_end)
        val spannable = text.toSpannable()
        spannable[0..text.length] = LinearGradientSpan(text, text, startColorInt, endColorInt)
        txtHello.text = spannable
    }

    companion object {
        const val TITLE_TEXT = "MEMO : Zi"
    }
}

