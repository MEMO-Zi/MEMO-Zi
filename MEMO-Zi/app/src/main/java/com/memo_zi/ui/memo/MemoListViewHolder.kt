package com.memo_zi.ui.memo

import androidx.recyclerview.widget.RecyclerView

import com.memo_zi.data.model.MemoItem
import com.memo_zi.databinding.ItemMemoListAllBinding

class MemoListViewHolder(private val binding: ItemMemoListAllBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(memoData: MemoItem.Memo) {
        binding.run {
            memoContent.text = memoData.contents
            memoDate.text = memoData.date
            memoTitle.text = memoData.title
        }
    }
}
