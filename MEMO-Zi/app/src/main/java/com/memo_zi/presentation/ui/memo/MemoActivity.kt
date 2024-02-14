package com.memo_zi.presentation.ui.memo

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isInvisible
import androidx.fragment.app.Fragment
import com.memo_zi.presentation.ui.memo.adapter.MemoAdapter
import com.memo_zi.R
import com.memo_zi.databinding.ActivityMemoBinding
import com.memo_zi.presentation.ui.diary.DiaryActivity
import com.memo_zi.presentation.ui.memo.adapter.MemoCategoryAdapter
import com.memo_zi.presentation.ui.setting.SettingActivity
import com.memo_zi.util.binding.BindingActivity
import kotlin.math.abs


class MemoActivity :
    BindingActivity<ActivityMemoBinding>(R.layout.activity_memo) {
    private val viewModel by viewModels<MemoViewModel>()
    private lateinit var memoAdapter: MemoAdapter
    private lateinit var categoryAdapter: MemoCategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initLayout()
    }

    private fun initLayout() {
        initMemoFragment()
        initAdapter()
        setMemoList()
        setupCarousel()
        clickToChangeActivity()
        setButton()
    }

    private fun setupCarousel() {
        binding.run {
            vpMemoCategoryList.offscreenPageLimit = 3
            val offsetBetweenPages =
                resources.getDimensionPixelOffset(R.dimen.viewpager_offset).toFloat()
            val heightDown =
                resources.getDimensionPixelOffset(R.dimen.viewpager_height_down).toFloat()
            val heightUp =
                resources.getDimensionPixelOffset(R.dimen.viewpager_height_up).toFloat()

            vpMemoCategoryList.setPageTransformer { page, position ->
                val myOffset = position * -(2 * offsetBetweenPages)
                //Y축 이동
                if (position != 0f) {
                    page.translationY =
                        (heightDown + (DEFAULT_SIZE - heightDown) * (1 - abs(position)))
                } else {
                    page.translationY =
                        -(heightUp + (DEFAULT_SIZE - heightUp) * (1 - abs(position)))
                }

                //좌우 이동 및 크기 스케일링
                if (position < -1) {
                    page.translationX = myOffset
                } else if (position <= 1) {
                    val scaleFactor = (MIN_SIZE + (1 - MIN_SIZE) * (1 - abs(position)))
                    page.scaleY = scaleFactor
                    page.translationX = myOffset
                } else {
                    page.translationX = myOffset
                }
            }
        }
    }

    private fun setButton() {
        binding.fabMemoAdd.setOnClickListener {
            Intent(this, MemoEditActivity::class.java).apply {
                startActivity(this)
            }
        }
        binding.layoutMemoSearch.setOnClickListener{
            Intent(this, MemoSearchActivity::class.java).apply {
                startActivity(this)
            }
        }
        binding.btnMemoCategoryEdit.setOnClickListener {
            replaceFragment(MEMO_CATEGORY)
            it.isInvisible = true
        }
    }

    private fun clickToChangeActivity() {
        binding.includeMemoTopAppbar.ivAllTopAppbarChange.setOnClickListener {
            Intent(this, DiaryActivity::class.java).apply {
                startActivity(this)
            }
        }
        binding.includeMemoTopAppbar.ivAllTopAppbarSetting.setOnClickListener {
            Intent(this, SettingActivity::class.java).apply {
                startActivity(this)
            }
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

    override fun onBackPressed() {
        binding.btnMemoCategoryEdit.isInvisible = false
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
            vpMemoCategoryList.adapter = categoryAdapter
            indicatorMemoCategory.setViewPager(vpMemoCategoryList)
            categoryAdapter.registerAdapterDataObserver(indicatorMemoCategory.adapterDataObserver)
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
        const val MIN_SIZE = 72f / 88f
        const val DEFAULT_SIZE = 1f
    }
}
