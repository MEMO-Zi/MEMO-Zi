package com.memo_zi.presentation.ui.diary.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.memo_zi.databinding.ItemDiaryFeedBinding
import com.memo_zi.databinding.ItemDiaryFeedTitleBinding
import com.memo_zi.presentation.model.DiaryFeedItem
import timber.log.Timber

class DiaryAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private val diaryList = mutableListOf<DiaryFeedItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            DIARY_TITLE -> DiaryFeedTitleViewHolder(
                ItemDiaryFeedTitleBinding.inflate(
                    inflater, parent, false
                )
            )

            DIARY_ALL_ITEM -> DiaryFeedViewHolder(
                ItemDiaryFeedBinding.inflate(
                    inflater, parent, false
                )
            )

            else -> throw RuntimeException("viewType error")
        }
    }

    override fun getItemCount() = diaryList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is DiaryFeedTitleViewHolder -> holder.onBind(diaryList[position] as DiaryFeedItem.Title)
            is DiaryFeedViewHolder -> holder.onBind(diaryList[position] as DiaryFeedItem.AllFeedItem)
        }
    }

    override fun getItemViewType(position: Int): Int = when (diaryList[position]) {
        is DiaryFeedItem.Title -> DIARY_TITLE
        is DiaryFeedItem.AllFeedItem -> DIARY_ALL_ITEM
    }

    fun setDiaryList(dataList: List<DiaryFeedItem>) {
        diaryList.clear()
        diaryList.addAll(dataList)
        Timber.tag("dataList").d(dataList.toString())
        notifyDataSetChanged()
    }

    companion object {
        const val DIARY_TITLE = 0
        const val DIARY_ALL_ITEM = 1
    }
}