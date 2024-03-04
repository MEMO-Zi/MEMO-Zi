package com.memo_zi.presentation.ui.memo.adapter

import androidx.recyclerview.widget.RecyclerView
import com.memo_zi.data.model.MemoItem
import com.memo_zi.databinding.ItemMemoCategorySelectBinding
import com.memo_zi.util.component.TextviewSetting

class MemoCategorySelectViewHolder(
    private val binding: ItemMemoCategorySelectBinding,
    private val selectedCategory: String
) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(categoryData: MemoItem.Category) {
        binding.run {
            if (selectedCategory == categoryData.title) {
                tvMemoSelectCategoryTitle.text = TextviewSetting().setTextBold(categoryData.title)
            } else tvMemoSelectCategoryTitle.text = categoryData.title
        }
    }
}