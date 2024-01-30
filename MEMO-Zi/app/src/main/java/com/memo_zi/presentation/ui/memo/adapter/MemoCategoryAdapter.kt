package com.memo_zi.presentation.ui.memo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.memo_zi.data.model.MemoItem
import com.memo_zi.databinding.ItemMemoCategoryBinding
import com.memo_zi.presentation.ui.memo.adapter.MemoListCategoryViewHolder
import timber.log.Timber

class MemoCategoryAdapter(
    private val context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private val categoryList = mutableListOf<MemoItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MemoListCategoryViewHolder(
            ItemMemoCategoryBinding.inflate(
                inflater, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MemoListCategoryViewHolder -> holder.onBind(categoryList[position] as MemoItem.Category)
        }
    }

    override fun getItemCount(): Int = categoryList.size

    fun setCategoryList(dataList: List<MemoItem>){
        categoryList.clear()
        categoryList.addAll(dataList)
        Timber.tag("memo").d(dataList.toString())
        notifyDataSetChanged()
    }

}
