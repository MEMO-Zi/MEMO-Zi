package com.memo_zi.presentation.ui.diary

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.memo_zi.R
import com.memo_zi.databinding.ActivityDiaryBinding
import com.memo_zi.presentation.ui.memo.MemoActivity
import com.memo_zi.presentation.ui.setting.SettingActivity
import com.memo_zi.util.binding.BindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DiaryActivity :
    BindingActivity<ActivityDiaryBinding>(R.layout.activity_diary) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initLayout()
        addListeners()
    }

    private fun addListeners() {
        binding.includeTopAppbar.ivAllTopAppbarChange.setOnClickListener {
            Intent(this, MemoActivity::class.java).apply {
                startActivity(this)
            }
        }
        binding.includeTopAppbar.ivAllTopAppbarSetting.setOnClickListener {
            Intent(this, SettingActivity::class.java).apply {
                startActivity(this)
            }
        }
        with(binding) {
            ivDiaryChangeFeed.setOnClickListener {
                ivDiaryChangeFeed.setImageResource(R.drawable.ic_feed_select_22)
                ivDiaryChangeCalendar.setImageResource(R.drawable.ic_calender_default_22)
                replaceFragment(DIARY_FEED)
            }

            ivDiaryChangeCalendar.setOnClickListener {
                ivDiaryChangeFeed.setImageResource(R.drawable.ic_feed_default_22)
                ivDiaryChangeCalendar.setImageResource(R.drawable.ic_calender_select_22)
                replaceFragment(DIARY_CALENDAR)
            }

            layoutDiaryDefault.setOnClickListener {
                layoutDiaryDefault.visibility = View.GONE
                layoutDiaryWriting.visibility = View.VISIBLE
            }
        }
    }

    private fun initLayout() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fcv_diary)
        if (currentFragment == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fcv_diary, DiaryFeedFragment())
                .commit()
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

    companion object {
        const val DIARY_FEED = "DiaryFeed"
        const val DIARY_CALENDAR = "DiaryCalendar"
    }
}
