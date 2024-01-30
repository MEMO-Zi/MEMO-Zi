package com.memo_zi.presentation.ui.memo

import androidx.recyclerview.widget.RecyclerView

import com.memo_zi.data.model.MemoItem
import com.memo_zi.databinding.ItemMemoListAllBinding

class MemoListViewHolder(private val binding: ItemMemoListAllBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(memoData: MemoItem.Memo) {
        binding.run {
            tvMemoContent.text = memoData.contents
            tvMemoDate.text = memoData.date
            tvMemoTitle.text = memoData.title
        }
    }
}
