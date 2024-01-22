package com.memo_zi.presentation.ui.diary

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.memo_zi.R
import com.memo_zi.databinding.ActivityDiaryBinding
import com.memo_zi.ui.memo.MemoActivity
import com.memo_zi.ui.setting.SettingActivity
import com.memo_zi.util.binding.BindingActivity

class DiaryActivity :
    BindingActivity<ActivityDiaryBinding>(R.layout.activity_diary) {

    companion object {
        const val DIARY_FEED = "DiaryFeed"
        const val DIARY_CALENDAR = "DiaryCalendar"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initDiaryFragment()
        changeActivity()
        clickDiaryWriting()
        changeDiaryFragment()
    }

    private fun changeActivity() {
        binding.tbDiary.setOnMenuItemClickListener() { menuItem ->
            when (menuItem.itemId) {
                R.id.item_diary_change -> {
                    Intent(this, MemoActivity::class.java).apply {
                        startActivity(this)
                    }
                    true
                }

                R.id.item_diary_setting -> {
                    Intent(this, SettingActivity::class.java).apply {
                        startActivity(this)
                    }
                    true
                }

                else -> false
            }
        }
    }

    private fun initDiaryFragment() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fcv_diary)
        if (currentFragment == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fcv_diary, DiaryFeedFragment())
                .commit()
        }
    }

    private fun clickDiaryWriting() {
        binding.run {
            llDiaryDefault.setOnClickListener {
                llDiaryDefault.visibility = View.GONE
                clDiaryAdd.visibility = View.VISIBLE
            }
        }
    }

    private fun changeDiaryFragment() {
        binding.run {
            ivDiaryFeed.setOnClickListener {
                ivDiaryFeed.setImageResource(R.drawable.ic_feed_black_17px)
                ivDiaryCalendar.setImageResource(R.drawable.ic_calendar_white_20px)
                replaceFragment(DIARY_FEED)
            }

            ivDiaryCalendar.setOnClickListener {
                ivDiaryFeed.setImageResource(R.drawable.ic_feed_white_17px)
                ivDiaryCalendar.setImageResource(R.drawable.ic_calendar_black_20px)
                replaceFragment(DIARY_CALENDAR)
            }
        }
    }

    private fun replaceFragment(name: String) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()

        val newFragment = when (name) {
            DIARY_FEED -> DiaryFeedFragment()
            DIARY_CALENDAR -> DiaryCalendarFragment()
            else -> Fragment()
        }
        fragmentTransaction.replace(R.id.fcv_diary, newFragment)
        fragmentTransaction.commit()
    }
}