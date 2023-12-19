package com.memo_zi.ui.memo

import android.content.Intent
import android.os.Bundle
import com.memo_zi.R
import com.memo_zi.databinding.ActivityMemoBinding
import com.memo_zi.ui.diary.DiaryActivity
import com.memo_zi.ui.setting.SettingActivity
import com.memo_zi.util.binding.BindingActivity

class MemoActivity :
    BindingActivity<ActivityMemoBinding>({ ActivityMemoBinding.inflate(it) }) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        changeDiaryActivity()
    }

    private fun changeDiaryActivity() {
        binding.tbMemo.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.item_memo_change -> {
                    Intent(this, DiaryActivity::class.java).apply {
                        startActivity(this)
                    }

                    true
                }

                R.id.item_memo_setting -> {
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