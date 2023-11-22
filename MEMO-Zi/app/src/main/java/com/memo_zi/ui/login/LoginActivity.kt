package com.memo_zi.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.memo_zi.R
import com.memo_zi.util.text.TextGradation

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        TextGradation(
            findViewById(R.id.logoText),
            TITLE_TEXT,
            ContextCompat.getColor(this, R.color.bg_start),
            ContextCompat.getColor(this, R.color.bg_end)
        )
    }

    companion object {
        const val TITLE_TEXT = "MEMO : Zi"
    }
}

