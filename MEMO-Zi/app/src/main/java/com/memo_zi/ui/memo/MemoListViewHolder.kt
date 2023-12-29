package com.memo_zi.ui.memo

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.memo_zi.data.model.DiaryItem
import com.memo_zi.databinding.ItemDiaryListAllBinding

class MemoListViewHolder(private val binding: ItemDiaryListAllBinding) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(diaryData: DiaryItem.AllItem) {
        binding.run {
            tvItemDiaryFeedDate.text = diaryData.diaryDate
            ivItemDiaryFeed.load(diaryData.diaryImgUrl)
            tvItemDiaryFeedLocation.text = diaryData.diaryLocation
            tvItemDiaryFeedContent.text = diaryData.diaryContent
        }
    }
}
