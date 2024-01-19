package com.memo_zi.ui.memo

import android.content.Intent
import android.os.Bundle
import com.memo_zi.databinding.ActivityMemoEditBinding
import com.memo_zi.util.binding.BindingActivity

class MemoEditActivity :
    BindingActivity<ActivityMemoEditBinding>({ ActivityMemoEditBinding.inflate(it) }) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupButton()
    }

    private fun setupButton() {
        binding.run {
            memoEditEnroll.setOnClickListener {
                Intent(this@MemoEditActivity, MemoActivity::class.java).apply {
                    startActivity(this)
                }
            }
//            memoBold.setOnClickListener {
//todo 메모 볼드체 등 기타 버튼에 대한 설정 필요
//            }
        }
    }
}