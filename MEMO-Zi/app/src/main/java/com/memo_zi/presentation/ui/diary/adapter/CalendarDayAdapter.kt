package com.memo_zi.presentation.ui.diary.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.memo_zi.R
import java.util.Date

class CalendarDayAdapter(val tempMonth: Int, val dayList: MutableList<Date>) :
    RecyclerView.Adapter<CalendarDayAdapter.DayView>() {
    class DayView(val layout: View) : RecyclerView.ViewHolder(layout)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayView {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_calendar_day, parent, false)

        return DayView(view)
    }

    override fun onBindViewHolder(holder: DayView, position: Int) {
        // 초기화
        var dayText: TextView = holder.layout.findViewById(R.id.tv_calendar_day)

        // 날짜 표시
        dayText.text = dayList[position].date.toString()
        if (tempMonth != dayList[position].month) {
            dayText.alpha = 0.4f
        }

        // 토요일이면 파란색 || 일요일이면 빨간색으로 색상표시
        if ((position + 1) % 7 == 0) {
            dayText.setTextColor(ContextCompat.getColor(holder.layout.context, R.color.sub_purple))
        } else if (position == 0 || position % 7 == 0) {
            dayText.setTextColor(ContextCompat.getColor(holder.layout.context, R.color.black))
        }
    }


    override fun getItemCount(): Int {
        return ROW * 7
    }

    companion object {
        const val ROW = 6
    }
}