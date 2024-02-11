package com.memo_zi.presentation.ui.onboarding

import android.os.Bundle
import android.view.View
import com.memo_zi.R
import com.memo_zi.databinding.FragmentOnboardingMemoBinding
import com.memo_zi.util.binding.BindingFragment
import com.memo_zi.util.component.TextGradation

class OnboardingMemoFragment :
    BindingFragment<FragmentOnboardingMemoBinding>(R.layout.fragment_onboarding_memo) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLayout()
    }

    private fun initLayout() {
        binding.run {
            TextGradation(
                tvOnboardingMemoTitle,
                resources.getString(R.string.app_name),
                resources.getColor(R.color.main_pink),
                resources.getColor(R.color.main_purple)
            )
        }
    }
}