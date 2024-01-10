package com.memo_zi.ui.memo

import androidx.recyclerview.widget.RecyclerView
import com.memo_zi.data.model.MemoItem
import com.memo_zi.databinding.ItemMemoCategoryBinding

class MemoListCategoryViewHolder(private val binding: ItemMemoCategoryBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun onBind(categoryData: MemoItem.Category) {
        binding.run {
//            categoryImg.src = categoryData.imageRes
        }
    }


}