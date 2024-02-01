package com.memo_zi.presentation.ui.memo.adapter

import androidx.recyclerview.widget.RecyclerView
import com.memo_zi.databinding.ItemMemoSearchSingleBinding
import com.memo_zi.presentation.model.MemoSearchFeedItem

class MemoSearchViewHolder(private val binding: ItemMemoSearchSingleBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(memoData: MemoSearchFeedItem.AllFeedItem) {
        binding.run {
            tvSingleMemoTitle.text = memoData.titleText
            tvSingleMemoContent.text = memoData.content
            tvSingleMemoDate.text = memoData.date
        }
    }
}