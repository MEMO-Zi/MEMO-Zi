package com.memo_zi.presentation.ui.onboarding

import android.os.Bundle
import android.view.View
import com.memo_zi.R
import com.memo_zi.databinding.FragmentOnboardingPopupBinding
import com.memo_zi.util.binding.BindingFragment
import com.memo_zi.util.component.TextGradation

class OnboardingPopupFragment :
    BindingFragment<FragmentOnboardingPopupBinding>(R.layout.fragment_onboarding_popup) {
    private var check = true


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLayout()
    }

    private fun initLayout() {
        binding.run {
            TextGradation(
                tvOnboardingPopupTitle,
                getString(R.string.app_name),
                resources.getColor(R.color.main_pink),
                resources.getColor(R.color.main_purple)
            )
        }
        initButton()
    }

    private fun initButton() {
        binding.run {
            layoutOnboardingCheck.setOnClickListener {
                check = !check
                checkEvent()
            }
            btnOnboardingPopup.setOnClickListener {
                (activity as OnboardingActivity).changeActivity()
            }
        }
    }

    private fun checkEvent() {
        when (check) {
            true -> binding.run {
                viewOnboardPopupCheckbox.background =
                    resources.getDrawable(R.drawable.ic_checked_checkbox)
                timepickerOnboardingPopup.setBackgroundColor(resources.getColor(R.color.g_02))
            }

            false -> binding.run {
                viewOnboardPopupCheckbox.background =
                    resources.getDrawable(R.drawable.ic_unchecked_checkbox)
                timepickerOnboardingPopup.setBackgroundColor(resources.getColor(R.color.white))
            }
        }
    }
}