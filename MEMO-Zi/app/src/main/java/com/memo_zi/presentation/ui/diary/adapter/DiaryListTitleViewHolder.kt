package com.memo_zi.presentation.ui.diary.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.memo_zi.presentation.model.DiaryItem
import com.memo_zi.databinding.ItemDiaryListTitleBinding

class DiaryListTitleViewHolder(private val binding: ItemDiaryListTitleBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(diaryData: DiaryItem.Title) {
        binding.ivDiaryTitle.load(diaryData.titleLogoImage)
    }
}