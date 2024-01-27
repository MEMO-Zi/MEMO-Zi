package com.memo_zi.presentation.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil.setContentView
import com.memo_zi.R
import com.memo_zi.util.binding.BindingActivity

class AuthActivity: BindingActivity(R.layout.activity_auth) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
    }
}