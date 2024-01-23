package com.memo_zi.presentation.ui.diary.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.memo_zi.databinding.ItemDiaryFeedBinding
import com.memo_zi.presentation.model.DiaryItem

class DiaryListAllViewHolder(private val binding: ItemDiaryFeedBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(diaryData: DiaryItem.AllItem) {
        binding.run {
            tvItemDiaryFeedDate.text = diaryData.diaryDate
            ivItemDiaryFeed.load(diaryData.diaryImgUrl)
            tvItemDiaryFeedLocation.text = diaryData.diaryLocation
            tvItemDiaryFeedContent.text = diaryData.diaryContent
        }
    }
}