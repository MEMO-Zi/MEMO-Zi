package com.memo_zi.ui.diary

import android.content.Intent
import android.os.Bundle
import com.memo_zi.R
import com.memo_zi.databinding.ActivityDiaryBinding
import com.memo_zi.ui.memo.MemoActivity
import com.memo_zi.ui.setting.SettingActivity
import com.memo_zi.util.binding.BindingActivity

class DiaryActivity :
    BindingActivity<ActivityDiaryBinding>({ ActivityDiaryBinding.inflate(it) }) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        changeDiaryActivity()
    }

    private fun changeDiaryActivity() {
        binding.tbDiaryMain.setOnMenuItemClickListener() { menuItem ->
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
}