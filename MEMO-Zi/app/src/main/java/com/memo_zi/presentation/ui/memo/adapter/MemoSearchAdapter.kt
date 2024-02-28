package com.memo_zi.presentation.ui.memo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.memo_zi.databinding.ItemMemoSearchSingleBinding
import com.memo_zi.databinding.ItemMemoSearchTitleBinding
import com.memo_zi.presentation.model.MemoSearchFeedItem

class MemoSearchAdapter(context: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private val memoList = mutableListOf<MemoSearchFeedItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            MEMO_TITLE -> MemoSearchTitleViewHolder(
                ItemMemoSearchTitleBinding.inflate(
                    inflater, parent, false
                )
            )
            MEMO_ITEM -> MemoSearchViewHolder(
                ItemMemoSearchSingleBinding.inflate(
                    inflater, parent, false
                )
            )
            else -> throw RuntimeException("viewType error")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MemoSearchTitleViewHolder -> holder.onBind(memoList[position] as MemoSearchFeedItem.Title)
            is MemoSearchViewHolder -> holder.onBind(memoList[position] as MemoSearchFeedItem.AllFeedItem)
        }
    }

    override fun getItemCount(): Int = memoList.size

    override fun getItemViewType(position: Int): Int = when(memoList[position]){
        is MemoSearchFeedItem.Title-> MEMO_TITLE
        is MemoSearchFeedItem.AllFeedItem -> MEMO_ITEM
    }

    fun setMemoList(dataList: List<MemoSearchFeedItem>) {
        memoList.clear()
        memoList.addAll(dataList)
        notifyDataSetChanged()
    }

    companion object {
        const val MEMO_TITLE = 0
        const val MEMO_ITEM = 1
    }
}
