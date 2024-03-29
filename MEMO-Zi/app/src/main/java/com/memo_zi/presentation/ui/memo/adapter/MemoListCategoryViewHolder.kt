package com.memo_zi.presentation.ui.memo.adapter

import androidx.recyclerview.widget.RecyclerView
import com.memo_zi.data.model.MemoItem
import com.memo_zi.databinding.ItemMemoCategoryBinding

class MemoListCategoryViewHolder(private val binding: ItemMemoCategoryBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(categoryData: MemoItem.Category) {
        binding.run {
            ivCategoryImg.setImageResource(categoryData.imageRes)
            categoryTitle.text = categoryData.title
        }
    }
}