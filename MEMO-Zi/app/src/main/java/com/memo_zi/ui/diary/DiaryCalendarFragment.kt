package com.memo_zi.ui.diary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.memo_zi.databinding.FragmentDiaryCalendarBinding
import com.memo_zi.util.base.BaseFragment

class DiaryCalendarFragment : BaseFragment<FragmentDiaryCalendarBinding>() {
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDiaryCalendarBinding = FragmentDiaryCalendarBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}