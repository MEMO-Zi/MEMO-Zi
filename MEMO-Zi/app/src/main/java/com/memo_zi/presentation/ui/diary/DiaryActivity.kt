package com.memo_zi.presentation.ui.diary

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.memo_zi.R
import com.memo_zi.databinding.ActivityDiaryBinding
import com.memo_zi.ui.memo.MemoActivity
import com.memo_zi.ui.setting.SettingActivity
import com.memo_zi.util.binding.BindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DiaryActivity :
    BindingActivity<ActivityDiaryBinding>(R.layout.activity_diary) {
    val viewModel by viewModels<DiaryViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initLayout()
    }

    private fun initLayout() {
        initDiaryFragment()
        changeActivity()
        clickDiaryWriting()
        changeDiaryFragment()
    }

    private fun changeActivity() {
        binding.tbDiary.setOnMenuItemClickListener { menuItem ->
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
        with(binding) {
            llDiaryDefault.setOnClickListener {
                llDiaryDefault.visibility = View.GONE
                clDiaryAdd.visibility = View.VISIBLE
            }
        }
    }

    private fun changeDiaryFragment() {
        with(binding) {
            ivDiaryFeed.setOnClickListener {
                ivDiaryFeed.setImageResource(R.drawable.ic_feed_select_22)
                ivDiaryCalendar.setImageResource(R.drawable.ic_calender_default_22)
                replaceFragment(DIARY_FEED)
            }

            ivDiaryCalendar.setOnClickListener {
                ivDiaryFeed.setImageResource(R.drawable.ic_feed_default_22)
                ivDiaryCalendar.setImageResource(R.drawable.ic_calender_select_22)
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

    companion object {
        const val DIARY_FEED = "DiaryFeed"
        const val DIARY_CALENDAR = "DiaryCalendar"
    }
}
