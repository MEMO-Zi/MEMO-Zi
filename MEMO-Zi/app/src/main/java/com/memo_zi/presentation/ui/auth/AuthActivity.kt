package com.memo_zi.presentation.ui.auth

import android.content.Intent
import android.os.Bundle
import com.memo_zi.R
import com.memo_zi.databinding.ActivityAuthBinding
import com.memo_zi.presentation.ui.onboarding.OnboardingActivity
import com.memo_zi.util.binding.BindingActivity
import com.memo_zi.util.component.TextGradation

class AuthActivity : BindingActivity<ActivityAuthBinding>(R.layout.activity_auth) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.run {
            TextGradation(
                tvAuthTitle,
                getString(R.string.app_name),
                getColor(R.color.main_pink),
                getColor(R.color.main_purple)
            )
            btnAuthKakao.setOnClickListener {
                navigateOnboarding()
            }
        }
    }

    private fun navigateOnboarding() {
        Intent(this, OnboardingActivity::class.java).apply {
            startActivity(this)
        }
        finish()
    }
}