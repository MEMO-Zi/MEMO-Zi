package com.memo_zi.presentation.ui.diary.calendar

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.memo_zi.R
import com.memo_zi.databinding.FragmentDiaryCalendarBinding
import com.memo_zi.presentation.ui.diary.DiaryViewModel
import com.memo_zi.util.binding.BindingFragment
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class DiaryCalendarFragment :
    BindingFragment<FragmentDiaryCalendarBinding>(R.layout.fragment_diary_calendar) {
    private val viewModel by viewModels<DiaryViewModel>()
    private lateinit var diaryCalendarAdapter: DiaryCalendarAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initLayout()
        addObservers()
    }

    private fun initLayout() {
        diaryCalendarAdapter = DiaryCalendarAdapter()
        binding.rvDiary.adapter = diaryCalendarAdapter

        initCalendarBottomSheet()
    }

    private fun addObservers() {
        viewModel.diaryCalendarList.observe(viewLifecycleOwner) { diaryList ->
            diaryCalendarAdapter.submitList(diaryList)
            diaryCalendarAdapter.currentList
        }
    }

    private fun initCalendarBottomSheet() {
        val bottomSheetBehavior = BottomSheetBehavior.from(binding.llDiaryCalendarBottomSheet)

        bottomSheetBehavior.addBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_HIDDEN -> {
                        Timber.d("state: hidden")
                    }

                    BottomSheetBehavior.STATE_EXPANDED -> {
                        Timber.d("state: expanded")
                    }

                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        Timber.d("state: collapsed")
                    }

                    BottomSheetBehavior.STATE_DRAGGING -> {
                        Timber.d("state: dragging")
                    }

                    BottomSheetBehavior.STATE_SETTLING -> {
                        Timber.d("state: settling")
                    }

                    BottomSheetBehavior.STATE_HALF_EXPANDED -> {
                        Timber.d("state: half expanded")
                    }
                }
            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
            }
        })
        val position: Int = Int.MAX_VALUE / 2

        binding.rvBottomSheetCalendar.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvBottomSheetCalendar.adapter = CalendarMonthAdapter(requireContext())

        // item의 위치 지정
        binding.rvBottomSheetCalendar.scrollToPosition(position)

        // 항목씩 스크롤 지정
        val snap = PagerSnapHelper()
        snap.attachToRecyclerView(binding.rvBottomSheetCalendar)
    }
}
