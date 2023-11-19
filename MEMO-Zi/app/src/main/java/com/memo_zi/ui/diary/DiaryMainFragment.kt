package com.memo_zi.ui.diary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.memo_zi.R
import com.memo_zi.databinding.FragmentDiaryMainBinding
import com.memo_zi.util.base.BaseFragment

class DiaryMainFragment : BaseFragment<FragmentDiaryMainBinding>() {
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDiaryMainBinding = FragmentDiaryMainBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        replaceContentFragment()
    }

    private fun replaceContentFragment() {
        val fragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
        binding.run {
            ivDiaryMainFeed.setOnClickListener {
                fragmentTransaction.replace(R.id.fcv_home_content, DiaryFeedFragment())
                ivDiaryMainFeed.setImageResource(R.drawable.ic_feed_black_17px)
                ivDiaryMainCalendar.setImageResource(R.drawable.ic_calendar_white_20px)
            }

            ivDiaryMainCalendar.setOnClickListener {
                fragmentTransaction.replace(R.id.fcv_home_content, DiaryCalendarFragment())
                ivDiaryMainFeed.setImageResource(R.drawable.ic_feed_white_17px)
                ivDiaryMainCalendar.setImageResource(R.drawable.ic_calendar_black_20px)
            }
        }
        fragmentTransaction.commit()
    }
}