package com.memo_zi.ui.diary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.memo_zi.databinding.FragmentDiaryCalendarBinding
import com.memo_zi.util.binding.BindingFragment

class DiaryCalendarFragment : BindingFragment<FragmentDiaryCalendarBinding>() {
    private val viewModel by viewModels<DiaryViewModel>()
    private lateinit var diaryAdapter: DiaryAdapter

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDiaryCalendarBinding =
        FragmentDiaryCalendarBinding.inflate(inflater, container, false)

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