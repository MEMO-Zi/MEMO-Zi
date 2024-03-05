package com.memo_zi.presentation.ui.memo.adapter

import android.graphics.Typeface
import androidx.recyclerview.widget.RecyclerView
import com.memo_zi.data.model.MemoItem
import com.memo_zi.databinding.ItemMemoCategorySelectBinding
import com.memo_zi.util.component.TextviewSetting

class MemoCategorySelectViewHolder(
    private val binding: ItemMemoCategorySelectBinding,
    private val selectedCategory: String
) :
    RecyclerView.ViewHolder(binding.root) {

    fun onBind(categoryData: MemoItem.Category, itemClick: (String) -> Unit) {
        binding.run {
            tvMemoSelectCategoryTitle.text = categoryData.title
            if (selectedCategory == categoryData.title) {
                // 타이틀을 Bold로 설정
                tvMemoSelectCategoryTitle.setTypeface(null, Typeface.BOLD)
            } else {
                // 타이틀을 기본 스타일로 설정
                tvMemoSelectCategoryTitle.setTypeface(null, Typeface.NORMAL)
            }
            binding.layoutMemoSelectCategory.setOnClickListener {
                itemClick(binding.tvMemoSelectCategoryTitle.text.toString())
            }
        }
    }
}