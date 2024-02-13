package com.memo_zi.presentation.ui.diary.feed

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.memo_zi.databinding.ItemDiaryFeedBinding
import com.memo_zi.presentation.model.DiaryItem

class DiaryFeedViewHolder(private val binding: ItemDiaryFeedBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(diaryData: DiaryItem.Item) {
        binding.run {
            tvDiaryFeedDate.text = diaryData.diaryDate
            ivDiaryFeedImg.load(diaryData.diaryImgUrl)
            tvDiaryFeedLocation.text = diaryData.diaryLocation
            tvDiaryFeedContent.text = diaryData.diaryContent
        }
    }
}