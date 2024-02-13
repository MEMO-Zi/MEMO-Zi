package com.memo_zi.presentation.ui.diary.feed

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.memo_zi.R
import com.memo_zi.databinding.FragmentDiaryFeedBinding
import com.memo_zi.presentation.ui.diary.DiaryViewModel
import com.memo_zi.util.binding.BindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DiaryFeedFragment : BindingFragment<FragmentDiaryFeedBinding>(R.layout.fragment_diary_feed) {
    private val viewModel by viewModels<DiaryViewModel>()
    private lateinit var diaryFeedAdapter: DiaryFeedAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initLayout()
        addObservers()
    }

    private fun initLayout() {
        diaryFeedAdapter = DiaryFeedAdapter(requireContext())
        binding.rvDiary.adapter = diaryFeedAdapter
    }

    private fun addObservers() {
        viewModel.diaryFeedList.observe(viewLifecycleOwner) { diaryList ->
            diaryFeedAdapter.setDiaryList(diaryList)
        }
    }
}