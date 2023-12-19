package com.memo_zi.ui.diary

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.memo_zi.R
import com.memo_zi.databinding.ActivityDiaryBinding
import com.memo_zi.ui.memo.MemoActivity
import com.memo_zi.ui.setting.SettingActivity
import com.memo_zi.util.binding.BindingActivity

class DiaryActivity :
    BindingActivity<ActivityDiaryBinding>({ ActivityDiaryBinding.inflate(it) }) {
    private val viewModel by viewModels<DiaryViewModel>()
    private lateinit var diaryAdapter: DiaryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        changeDiaryActivity()
        clickDiaryWriting()
        initAdapter()
        setDiaryList()
    }

    private fun changeDiaryActivity() {
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

    private fun clickDiaryWriting() {
        binding.run {
            llDiaryDefault.setOnClickListener {
                llDiaryDefault.visibility = View.GONE
                clDiaryAdd.visibility = View.VISIBLE
            }
        }
    }

    private fun initAdapter() {
        diaryAdapter = DiaryAdapter(this)
        binding.rvDiary.adapter = diaryAdapter
    }

    private fun setDiaryList() {
        viewModel.diaryList.observe(this) { diaryList ->
            diaryAdapter.setDiaryList(diaryList)
        }
    }
}