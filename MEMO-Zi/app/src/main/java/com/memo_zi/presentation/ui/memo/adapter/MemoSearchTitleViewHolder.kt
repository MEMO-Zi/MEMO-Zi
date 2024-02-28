package com.memo_zi.presentation.ui.memo.adapter

import androidx.recyclerview.widget.RecyclerView
import com.memo_zi.R
import com.memo_zi.databinding.ItemMemoSearchTitleBinding
import com.memo_zi.presentation.model.MemoSearchFeedItem

class MemoSearchTitleViewHolder(private val binding: ItemMemoSearchTitleBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(memoData: MemoSearchFeedItem.Title) {
        binding.run {
            tvMemoSearchTitle.text = memoData.titleText
            tvMemoSearchAmount.text = root.resources.getString(R.string.memo_search_amount).format(3)
        }
    }
}