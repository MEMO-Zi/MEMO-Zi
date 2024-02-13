package com.memo_zi.presentation.ui.diary.calendar

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.memo_zi.databinding.ItemCalendarDayBinding
import java.util.Date

class CalendarDayAdapter(
    private val context: Context,
    private val currentMonth: Int,
    private val dayList: MutableList<Date>
) : RecyclerView.Adapter<CalendarDayAdapter.DayViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DayViewHolder(
            ItemCalendarDayBinding.inflate(inflater, parent, false)
        )

    override fun getItemCount(): Int {
        return ROW * COLUMN
    }

    override fun onBindViewHolder(holder: DayViewHolder, position: Int) {
        holder.onBind(position)
    }

    inner class DayViewHolder(
        private val binding: ItemCalendarDayBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(position: Int) {
            binding.tvCalendarDay.text = dayList[position].date.toString()
            if (currentMonth != dayList[position].month) {
                binding.tvCalendarDay.text = ""
            }
        }
    }

    companion object {
        const val ROW = 6
        const val COLUMN = 7
    }
}