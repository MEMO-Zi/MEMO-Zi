package com.memo_zi.ui.home

import android.content.Intent
import android.os.Bundle
import com.memo_zi.R
import com.memo_zi.databinding.ActivityHomeBinding
import com.memo_zi.ui.diary.DiaryFeedFragment
import com.memo_zi.ui.diary.DiaryMainFragment
import com.memo_zi.ui.memo.MemoMainFragment
import com.memo_zi.ui.setting.SettingActivity
import com.memo_zi.util.base.BaseActivity

class HomeActivity : BaseActivity<ActivityHomeBinding>({ ActivityHomeBinding.inflate(it) }) {
    var isShowingFirstFragment = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initStartFragment()
        initMenuListener()
    }

    private fun initMenuListener() {
        binding.tbHome.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.mi_home_change_fragment -> {
                    if (isShowingFirstFragment) {
                        menuItem.setIcon(R.drawable.ic_change_memo_24px)
                        replaceMainFragment()
                    } else {
                        menuItem.setIcon(R.drawable.ic_change_diary_24px)
                        replaceMainFragment()
                    }
                    true
                }

                R.id.mi_home_setting -> {
                    Intent(this, SettingActivity::class.java).apply {
                        startActivity(this)
                    }
                    true
                }

                else -> false
            }
        }
    }

    private fun initStartFragment() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fcv_home_main)
        if (currentFragment == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fcv_home_main, MemoMainFragment())
                .commit()
        }
    }

    private fun replaceMainFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        if (isShowingFirstFragment) {
            transaction.replace(R.id.fcv_home_main, DiaryMainFragment())
            transaction.replace(R.id.fcv_home_content, DiaryFeedFragment())
        } else {
            transaction.replace(R.id.fcv_home_main, MemoMainFragment())
            transaction.replace(R.id.fcv_home_content, MemoMainFragment())
        }
        transaction.commit()
        isShowingFirstFragment = !isShowingFirstFragment
    }
}