package com.memo_zi.presentation.ui.diary.calendar

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.memo_zi.databinding.ItemCalendarMonthBinding
import java.util.Calendar
import java.util.Date

class CalendarMonthAdapter(
    private val context: Context
) : RecyclerView.Adapter<CalendarMonthAdapter.MonthViewHolder>() {
    private val inflater by lazy { LayoutInflater.from(context) }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MonthViewHolder(
        context,
        ItemCalendarMonthBinding.inflate(inflater, parent, false)
    )

    override fun getItemCount() = Int.MAX_VALUE / 2

    override fun onBindViewHolder(holder: CalendarMonthAdapter.MonthViewHolder, position: Int) {
        holder.onBind()
    }

    inner class MonthViewHolder(
        private val context: Context,
        private val binding: ItemCalendarMonthBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind() {
            val calendar: Calendar = Calendar.getInstance()

            //달 구하기
            calendar.time = Date() //현재 날짜 초기화
            calendar.set(Calendar.DAY_OF_MONTH, 1) //스크롤시 현재 월의 1일로 이동
            calendar.add(Calendar.MONTH, adapterPosition) //스크롤시 포지션 만큼 달 이동

            // 현재 날짜 출력
            binding.tvBottomSheetCalendar.text =
                "${calendar.get(Calendar.YEAR)}년 ${calendar.get(Calendar.MONTH) + 1}월"

            val currentMonth = calendar.get(Calendar.MONTH)

            // 6주 7일로 날짜를 표시
            val dayList: MutableList<Date> = MutableList(6 * 7) { Date() }

            for (i in 0..5) { //주
                for (k in 0..6) { //요일
                    //각 달의 요일만큼 캘린더에 보여진다
                    //요일 표시
                    calendar.add(
                        Calendar.DAY_OF_MONTH,
                        (1 - calendar.get(Calendar.DAY_OF_WEEK)) + k
                    )
                    dayList[i * 7 + k] = calendar.time //배열 인덱스 만큼 요일 데이터 저장
                }
                //주 표시
                calendar.add(Calendar.WEEK_OF_MONTH, 1)
            }

            binding.rvCalendarMonthDay.layoutManager = GridLayoutManager(context, 7)
            binding.rvCalendarMonthDay.adapter = CalendarDayAdapter(context, currentMonth, dayList)
        }
    }
}