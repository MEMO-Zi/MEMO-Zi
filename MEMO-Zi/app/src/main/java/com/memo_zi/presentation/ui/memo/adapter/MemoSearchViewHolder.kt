package com.memo_zi.presentation.ui.memo.adapter

import androidx.recyclerview.widget.RecyclerView
import com.memo_zi.data.model.MemoItem
import com.memo_zi.databinding.ItemMemoSingleBinding
import com.memo_zi.presentation.model.MemoSearchFeedItem

class MemoSearchViewHolder(private val binding: ItemMemoSingleBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(memoData: MemoSearchFeedItem.AllFeedItem) {
        binding.run {
            tvSingleMemoTitle.text = memoData.titleText
            tvSingleMemoContent.text = memoData.content
            tvSingleMemoDate.text = memoData.date
        }
    }
}