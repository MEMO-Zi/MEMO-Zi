package com.memo_zi.ui.memo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.view.isInvisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.hadi.viewpager2carousel.MemoAdapter
import com.memo_zi.R
import com.memo_zi.databinding.ActivityMemoBinding
import com.memo_zi.presentation.ui.diary.DiaryActivity
import com.memo_zi.ui.setting.SettingActivity
import com.memo_zi.util.binding.BindingActivity
import kotlin.math.absoluteValue


class MemoActivity :
    BindingActivity<ActivityMemoBinding>(R.layout.activity_memo) {

    private val viewModel by viewModels<MemoViewModel>()
    private lateinit var memoAdapter: MemoAdapter
    private lateinit var categoryAdapter: MemoCategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initMemoFragment()
        initAdapter()
        setMemoList()
        // 페이지 간의 간격 설정
        setupCarousel()
        changeMemoActivity()
        setButton()
    }

    private fun setupCarousel() {
        binding.run {
            memoViewpager.offscreenPageLimit = 3
            val pageMargin = resources.getDimensionPixelOffset(R.dimen.pageMargin)
            val pageTransformer = ViewPager2.PageTransformer { page: View, position: Float ->
                val offset = position * -2.0f
                //todo 방향 전환 양수로 해서
                page.translationX = offset * (page.width - pageMargin * 2)
                val scale =
                    if (position.absoluteValue < 0.5) 1f - 0.2f * position.absoluteValue else 0.8f
                page.scaleX = scale
                page.scaleY = scale
            }
            memoViewpager.setPageTransformer(pageTransformer)
            memoViewpager.clipToPadding = false
            memoViewpager.clipChildren = false
            memoViewpager.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
            memoViewpager.setPadding(pageMargin, 0, pageMargin, 0)

        }
    }

    private fun setButton() {
        binding.fabMemoAdd.setOnClickListener {
            Intent(this, MemoEditActivity::class.java).apply {
                startActivity(this)
            }
        }
        binding.memoBtnCategoryEdit.setOnClickListener {
            replaceFragment(MEMO_CATEGORY)
            it.isInvisible = true
        }
    }

    private fun replaceFragment(name: String) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()

        val newFragment = when (name) {
            MEMO_FEED -> MemoFeedFragment()
            MEMO_CATEGORY -> MemoCategoryFragment()
            else -> Fragment()
        }
        fragmentTransaction
            .replace(R.id.fcv_memo, newFragment)
            .addToBackStack(null)
            .commit()
    }

    private fun changeMemoActivity() {
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

    override fun onBackPressed() {//todo 추후 더 나은 로직 확인 필요
        binding.memoBtnCategoryEdit.isInvisible = false
        super.onBackPressed()
    }

    private fun initMemoFragment() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fcv_memo)
        if (currentFragment == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fcv_memo, MemoFeedFragment())
                .commit()
        }
    }

    private fun initAdapter() {
        memoAdapter = MemoAdapter(this)
        categoryAdapter = MemoCategoryAdapter(this)
        binding.run {
            memoViewpager.adapter = categoryAdapter
            memoIndicator.setViewPager(memoViewpager)
            categoryAdapter.registerAdapterDataObserver(memoIndicator.adapterDataObserver)
        }

    }

    private fun setMemoList() {
        viewModel.memoList.observe(this) { memoList ->
            memoAdapter.setMemoList(memoList)
        }
        viewModel.categoryList.observe(this) { categoryList ->
            categoryAdapter.setCategoryList(categoryList)
        }
    }


    companion object {
        const val MEMO_FEED = "MemoFeed"
        const val MEMO_CATEGORY = "MemoCategory"
    }
}
