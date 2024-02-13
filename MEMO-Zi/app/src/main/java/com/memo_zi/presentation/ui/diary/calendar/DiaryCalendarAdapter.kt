package com.memo_zi.presentation.ui.diary.calendar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.memo_zi.databinding.ItemDiaryCalendarBinding
import com.memo_zi.presentation.model.DiaryItem
import com.memo_zi.util.ItemDiffCallback

class DiaryCalendarAdapter :
    ListAdapter<DiaryItem.Item, DiaryCalendarViewHolder>(
        ItemDiffCallback<DiaryItem.Item>(
            onItemsTheSame = { old, new -> old.diaryDate == new.diaryDate },
            onContentsTheSame = { old, new -> old == new }
        )
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DiaryCalendarViewHolder(
        ItemDiaryCalendarBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: DiaryCalendarViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}