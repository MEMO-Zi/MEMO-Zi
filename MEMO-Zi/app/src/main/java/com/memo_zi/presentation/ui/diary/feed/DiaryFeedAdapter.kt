package com.memo_zi.presentation.ui.diary.feed

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.memo_zi.databinding.ItemDiaryFeedBinding
import com.memo_zi.databinding.ItemDiaryFeedTitleBinding
import com.memo_zi.presentation.model.DiaryItem
import timber.log.Timber

class DiaryFeedAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private val diaryList = mutableListOf<DiaryItem>()

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
            is DiaryFeedTitleViewHolder -> holder.onBind(diaryList[position] as DiaryItem.FeedTitle)
            is DiaryFeedViewHolder -> holder.onBind(diaryList[position] as DiaryItem.Item)
        }
    }

    override fun getItemViewType(position: Int): Int = when (diaryList[position]) {
        is DiaryItem.FeedTitle -> DIARY_TITLE
        is DiaryItem.Item -> DIARY_ALL_ITEM
    }

    fun setDiaryList(dataList: List<DiaryItem>) {
        diaryList.clear()
        diaryList.addAll(dataList)
        notifyDataSetChanged()
    }

    companion object {
        const val DIARY_TITLE = 0
        const val DIARY_ALL_ITEM = 1
    }
}