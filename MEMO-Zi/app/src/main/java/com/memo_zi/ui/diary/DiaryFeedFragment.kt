package com.memo_zi.ui.diary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.memo_zi.R
import com.memo_zi.databinding.FragmentDiaryFeedBinding
import com.memo_zi.util.base.BaseFragment

class DiaryFeedFragment : BaseFragment<FragmentDiaryFeedBinding>() {
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDiaryFeedBinding = FragmentDiaryFeedBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}