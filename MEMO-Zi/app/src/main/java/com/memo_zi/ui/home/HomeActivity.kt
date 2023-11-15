package com.memo_zi.ui.home

import android.os.Bundle
import com.memo_zi.R
import com.memo_zi.databinding.ActivityHomeBinding
import com.memo_zi.ui.diary.DiaryFeedFragment
import com.memo_zi.ui.memo.MemoMainFragment
import com.memo_zi.util.base.BaseActivity

class HomeActivity : BaseActivity<ActivityHomeBinding>({ ActivityHomeBinding.inflate(it) }) {
    var isShowingFirstFragment = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initReplaceFragment()
    }

    private fun initReplaceFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        if (isShowingFirstFragment) {
            val secondFragment = DiaryFeedFragment()
            transaction.replace(R.id.fcv_home, secondFragment)
        } else {
            val firstFragment = MemoMainFragment()
            transaction.replace(R.id.fcv_home, firstFragment)
        }
        transaction.addToBackStack(null)
        transaction.commit()
        isShowingFirstFragment = !isShowingFirstFragment
    }
}