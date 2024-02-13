package com.memo_zi.presentation.ui.onboarding

import android.os.Bundle
import android.view.View
import com.memo_zi.R
import com.memo_zi.databinding.FragmentOnboardingGreetingBinding
import com.memo_zi.util.binding.BindingFragment
import com.memo_zi.util.component.TextGradation

class OnboardingGreetingFragment :
    BindingFragment<FragmentOnboardingGreetingBinding>(R.layout.fragment_onboarding_greeting) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initLayout()
    }

    private fun initLayout() {
        TextGradation(
            context= requireContext(),
            textView = binding.tvOnboardingGreetingTitle
        )
        binding.tvOnboardingGreetingContent.text =
            resources.getString(R.string.onboarding_greeting, "김명석")
    }
}