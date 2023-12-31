package com.memo_zi.ui.diary

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.memo_zi.data.model.DiaryItem
import com.memo_zi.databinding.ItemDiaryListAllBinding
import com.memo_zi.databinding.ItemDiaryListTitleBinding
import timber.log.Timber

class DiaryAdapter(context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }
    private val diaryList = mutableListOf<DiaryItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            DIARY_TITLE -> DiaryListTitleViewHolder(
                ItemDiaryListTitleBinding.inflate(
                    inflater, parent, false
                )
            )

            DIARY_ALL_ITEM -> DiaryListAllViewHolder(
                ItemDiaryListAllBinding.inflate(
                    inflater, parent, false
                )
            )

            else -> throw RuntimeException("viewType error")
        }
    }

    override fun getItemCount() = diaryList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is DiaryListTitleViewHolder -> holder.onBind(diaryList[position] as DiaryItem.Title)
            is DiaryListAllViewHolder -> holder.onBind(diaryList[position] as DiaryItem.AllItem)
        }
    }

    override fun getItemViewType(position: Int): Int = when (diaryList[position]) {
        is DiaryItem.Title -> DIARY_TITLE
        is DiaryItem.AllItem -> DIARY_ALL_ITEM
    }

    fun setDiaryList(dataList: List<DiaryItem>) {
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