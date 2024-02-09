package com.memo_zi.presentation.ui.onboarding;

import android.content.Intent
import android.os.Bundle
import com.memo_zi.R
import com.memo_zi.databinding.ActivityOnboardingBinding
import com.memo_zi.presentation.ui.memo.MemoActivity
import com.memo_zi.util.binding.BindingActivity

class OnboardingActivity :
    BindingActivity<ActivityOnboardingBinding>(R.layout.activity_onboarding) {
    private lateinit var onboardingAdapter: OnboardingAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        onboardingAdapter = OnboardingAdapter(this)
        binding.run {
            vpOnboarding.adapter = onboardingAdapter
            indicatorOnboarding.setViewPager(vpOnboarding)
        }
    }

    fun changeActivity() {
        Intent(this, MemoActivity::class.java).apply {
            startActivity(this)
        }
    }
}