package com.memo_zi.presentation.ui.memo.adapter

import androidx.recyclerview.widget.RecyclerView
import com.memo_zi.databinding.ItemMemoSearchTitleBinding
import com.memo_zi.presentation.model.MemoSearchFeedItem

class MemoSearchTitleViewHolder(private val binding: ItemMemoSearchTitleBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(memoData: MemoSearchFeedItem.Title) {
        binding.run {
            tvMemoSearchTitle.text = memoData.titleText
            tvMemoSearchAmount.text=  AMOUT_TEXT.format(memoData.amount)
        }
    }

    companion object{
        const val AMOUT_TEXT = "카테고리에서 %d개의 메모를 발견했습니다!"
    }
}