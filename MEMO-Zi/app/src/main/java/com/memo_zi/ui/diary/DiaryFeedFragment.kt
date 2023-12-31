package com.memo_zi.ui.diary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.memo_zi.databinding.FragmentDiaryFeedBinding
import com.memo_zi.util.binding.BindingFragment

class DiaryFeedFragment : BindingFragment<FragmentDiaryFeedBinding>() {
    private val viewModel by viewModels<DiaryViewModel>()
    private lateinit var diaryAdapter: DiaryAdapter

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDiaryFeedBinding = FragmentDiaryFeedBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        setDiaryList()
    }

    private fun initAdapter() {
        diaryAdapter = DiaryAdapter(requireContext())
        binding.rvDiary.adapter = diaryAdapter
    }

    private fun setDiaryList() {
        viewModel.diaryList.observe(viewLifecycleOwner) { diaryList ->
            diaryAdapter.setDiaryList(diaryList)
        }
    }
}