package com.memo_zi.presentation.ui.diary

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.memo_zi.R
import com.memo_zi.databinding.FragmentDiaryFeedBinding
import com.memo_zi.presentation.ui.diary.adapter.DiaryAdapter
import com.memo_zi.util.binding.BindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DiaryFeedFragment : BindingFragment<FragmentDiaryFeedBinding>(R.layout.fragment_diary_feed) {
    private val viewModel by viewModels<DiaryViewModel>()
    private lateinit var diaryAdapter: DiaryAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initLayout()
        addObservers()
    }

    private fun initLayout() {
        diaryAdapter = DiaryAdapter(requireContext())
        binding.rvDiary.adapter = diaryAdapter
    }

    private fun addObservers() {
        viewModel.diaryList.observe(viewLifecycleOwner) { diaryList ->
            diaryAdapter.setDiaryList(diaryList)
        }
    }
}