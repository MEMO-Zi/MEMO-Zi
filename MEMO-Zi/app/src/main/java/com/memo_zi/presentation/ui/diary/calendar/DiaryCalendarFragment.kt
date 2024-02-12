package com.memo_zi.presentation.ui.diary.calendar

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.memo_zi.R
import com.memo_zi.databinding.FragmentDiaryCalendarBinding
import com.memo_zi.presentation.ui.diary.DiaryViewModel
import com.memo_zi.presentation.ui.diary.feed.DiaryFeedAdapter
import com.memo_zi.util.binding.BindingFragment
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class DiaryCalendarFragment :
    BindingFragment<FragmentDiaryCalendarBinding>(R.layout.fragment_diary_calendar) {
    private val viewModel by viewModels<DiaryViewModel>()
    private lateinit var diaryFeedAdapter: DiaryFeedAdapter
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<LinearLayout>
    private lateinit var recyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initLayout()
        addObservers()
    }

    private fun initLayout() {
        diaryFeedAdapter = DiaryFeedAdapter(requireContext())
        binding.rvDiary.adapter = diaryFeedAdapter

        initCalendarBottomSheet()
    }

    private fun addObservers() {
        viewModel.diaryList.observe(viewLifecycleOwner) { diaryList ->
            diaryFeedAdapter.setDiaryList(diaryList)
        }
    }

    private fun initCalendarBottomSheet() {
        bottomSheetBehavior =
            BottomSheetBehavior.from(binding.diaryBottomSheet.llBottomSheet)

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
        recyclerView = binding.diaryBottomSheet.rvBottomSheetCalendar
        val position: Int = Int.MAX_VALUE / 2

        binding.diaryBottomSheet.rvBottomSheetCalendar.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.diaryBottomSheet.rvBottomSheetCalendar.adapter = CalendarMonthAdapter()

        //item의 위치 지정
        binding.diaryBottomSheet.rvBottomSheetCalendar.scrollToPosition(position)

        //항목씩 스크롤 지정
        val snap = PagerSnapHelper()
        snap.attachToRecyclerView(binding.diaryBottomSheet.rvBottomSheetCalendar)

        binding.diaryBottomSheet.rvBottomSheetCalendar.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }
}
