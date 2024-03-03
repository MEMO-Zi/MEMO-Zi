package com.memo_zi.presentation.ui.memo.adapter

import androidx.recyclerview.widget.RecyclerView
import com.memo_zi.data.model.MemoItem
import com.memo_zi.databinding.ItemMemoCategorySelectBinding

class MemoCategorySelectViewHolder(private val binding: ItemMemoCategorySelectBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(categoryData: MemoItem.Category) {
        binding.run {
            tvMemoSelectCategoryTitle.text = categoryData.title
        }
    }
}