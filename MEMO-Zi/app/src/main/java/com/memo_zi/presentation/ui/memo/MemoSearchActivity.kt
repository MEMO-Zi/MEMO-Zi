package com.memo_zi.presentation.ui.memo

import android.os.Bundle
import android.view.KeyEvent
import android.view.KeyEvent.KEYCODE_ENTER
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.memo_zi.R
import com.memo_zi.databinding.ActivityMemoSearchBinding
import com.memo_zi.presentation.ui.memo.adapter.MemoSearchAdapter
import com.memo_zi.util.binding.BindingActivity

class MemoSearchActivity
    : BindingActivity<ActivityMemoSearchBinding>(R.layout.activity_memo_search) {

    private val viewModel by viewModels<MemoSearchViewModel>()
    private lateinit var memoSearchAdapter: MemoSearchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initLayout()
    }

    private fun initLayout() {
        initFragment()
        initAdapter()
        setMemoList()
        setButton()
    }

    private fun initAdapter() {
        memoSearchAdapter = MemoSearchAdapter(this)
    }

    private fun setMemoList() {
        viewModel.memoList.observe(this) { memoList ->
            memoSearchAdapter.setMemoList(memoList)
        }
    }

    private fun setButton() {
        binding.run {
            btnCancel.setOnClickListener {
                finish()
            }
            btnMemoSearchDelete.setOnClickListener {
                etSearchText.text.clear()
            }
        }
    }

    private fun setSearchEvent() {
        binding.etSearchText.setOnKeyListener { v, keycode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keycode == KEYCODE_ENTER) {
                searchMemo(binding.etSearchText.text.toString())
                //todo api 연결  adapter 에 데이터 넘기기
            }
            true
        }
    }

    private fun searchMemo(name: String) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()

        val newFragment = when (name) {
            MemoActivity.MEMO_FEED -> MemoFeedFragment()
            MemoActivity.MEMO_CATEGORY -> MemoCategoryFragment()
            else -> Fragment()
        }
        fragmentTransaction
            .replace(R.id.fcv_memo_search, newFragment)
            .addToBackStack(null)
            .commit()
    }

    private fun initFragment() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fcv_memo_search)
        if (currentFragment == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fcv_memo_search, MemoSearchFragment())
                .commit()
        }
    }

}