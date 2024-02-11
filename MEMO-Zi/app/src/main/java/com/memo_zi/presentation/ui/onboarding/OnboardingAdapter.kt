package com.memo_zi.presentation.ui.onboarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter


class OnboardingAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    private val fragments =
        listOf<Fragment>(
            OnboardingGreetingFragment(),
            OnboardingMemoFragment(),
            OnboardingDiaryFragment(),
            OnboardingPopupFragment()
        )

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}