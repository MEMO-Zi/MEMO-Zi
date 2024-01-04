package com.memo_zi.ui.memo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.hadi.viewpager2carousel.MemoAdapter
import com.memo_zi.R
import com.memo_zi.data.model.MemoCategory
import com.memo_zi.databinding.ActivityMemoBinding
import com.memo_zi.ui.diary.DiaryActivity
import com.memo_zi.ui.setting.SettingActivity
import com.memo_zi.util.binding.BindingActivity
import kotlin.math.absoluteValue

class MemoActivity :
    BindingActivity<ActivityMemoBinding>({ ActivityMemoBinding.inflate(it) }) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val categories = listOf(
            MemoCategory(R.drawable.img_category, "투두리스트"),
            MemoCategory(R.drawable.img_category2, "하기싫은것"),
            MemoCategory(R.drawable.img_category, "해야만하는것")
        )
        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        val modelAdapter = MemoAdapter(this, categories)
        viewPager.adapter = modelAdapter

        // 페이지 간의 간격 설정
        setupCarousel()
        changeMemoActivity()
    }

    private fun setupCarousel() {
        val viewPager: ViewPager2 = findViewById(R.id.viewPager)
        viewPager.offscreenPageLimit = 3
        val pageMargin = resources.getDimensionPixelOffset(R.dimen.pageMargin)
        val pageTransformer = ViewPager2.PageTransformer { page: View, position: Float ->
            val offset = position * -2.0f
            page.translationX = offset * (page.width - pageMargin * 2)
            val scale = if (position.absoluteValue < 0.5) 1f - 0.2f * position.absoluteValue else 0.8f
            page.scaleX = scale
            page.scaleY = scale
        }
        viewPager.setPageTransformer(pageTransformer)
        viewPager.clipToPadding = false
        viewPager.clipChildren = false
        viewPager.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        viewPager.setPadding(pageMargin, 0, pageMargin, 0)

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
}
