package com.memo_zi.presentation.ui.diary.calendar

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.memo_zi.databinding.ItemDiaryCalendarBinding
import com.memo_zi.presentation.model.DiaryItem

class DiaryCalendarViewHolder(private val binding: ItemDiaryCalendarBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(diaryData: DiaryItem.Item) {
        binding.run {
            tvDiaryCalendarDate.text = diaryData.diaryDate
            ivDiaryCalendarImg.load(diaryData.diaryImgUrl)
            tvDiaryCalendarLocation.text = diaryData.diaryLocation
            tvDiaryCalendarContent.text = diaryData.diaryContent
        }
    }
}