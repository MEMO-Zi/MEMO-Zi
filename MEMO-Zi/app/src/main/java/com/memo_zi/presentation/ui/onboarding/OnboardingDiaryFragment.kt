package com.memo_zi.presentation.ui.onboarding

import android.os.Bundle
import android.view.View
import com.memo_zi.R
import com.memo_zi.databinding.FragmentOnboardingDiaryBinding
import com.memo_zi.util.binding.BindingFragment
import com.memo_zi.util.component.TextGradation

class OnboardingDiaryFragment :
    BindingFragment<FragmentOnboardingDiaryBinding>(R.layout.fragment_onboarding_diary) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.run {
            TextGradation(
                tvOnboardingDiaryTitle,
                resources.getString(R.string.app_name),
                resources.getColor(R.color.main_pink),
                resources.getColor(R.color.main_purple)
            )
        }
    }
}