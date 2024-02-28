package com.memo_zi.presentation.ui.memo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.memo_zi.data.model.MemoItem
import com.memo_zi.databinding.ItemMemoCategoryBinding
import com.memo_zi.databinding.ItemMemoListAllBinding

class MemoAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private val memoList = mutableListOf<MemoItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            MEMO_CATEGORY -> MemoListCategoryViewHolder(
                ItemMemoCategoryBinding.inflate(
                    inflater, parent, false
                )
            )
            MEMO_ITEM -> MemoListViewHolder(
                ItemMemoListAllBinding.inflate(
                    inflater, parent, false
                )
            )
            else -> throw RuntimeException("viewType error")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MemoListCategoryViewHolder -> holder.onBind(memoList[position] as MemoItem.Category)
            is MemoListViewHolder -> holder.onBind(memoList[position] as MemoItem.Memo)
        }
    }

    override fun getItemCount(): Int = memoList.size

    override fun getItemViewType(position: Int): Int = when(memoList[position]){
        is MemoItem.Category -> MEMO_CATEGORY
        is MemoItem.Memo -> MEMO_ITEM
    }
    fun setMemoList(dataList: List<MemoItem>) {
        memoList.clear()
        memoList.addAll(dataList)
        notifyDataSetChanged()
    }

    companion object {
        const val MEMO_CATEGORY = 0
        const val MEMO_ITEM = 1
    }
}