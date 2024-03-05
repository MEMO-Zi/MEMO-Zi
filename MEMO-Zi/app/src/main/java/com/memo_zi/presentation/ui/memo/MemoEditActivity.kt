package com.memo_zi.presentation.ui.memo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import com.memo_zi.R
import com.memo_zi.databinding.ActivityMemoEditBinding
import com.memo_zi.presentation.ui.memo.adapter.MemoCategorySelectAdapter
import com.memo_zi.util.binding.BindingActivity

class MemoEditActivity : BindingActivity<ActivityMemoEditBinding>(R.layout.activity_memo_edit) {
    private val viewModel by viewModels<MemoViewModel>()
    private var selectCategory = "투두리스트"
    private lateinit var categoryAdapter: MemoCategorySelectAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initLayout()
    }

    private fun initLayout() {
        setupButton()
        initAdapter()
        setButtonEnable()
    }

    private fun setupCategoryTitle(text: String) {
        selectCategory = text
        binding.tvMemoEditCategoryName.text = selectCategory
    }

    private fun setupButton() {
        binding.run {
            btnMemoEditEnroll.setOnClickListener {
                Intent(this@MemoEditActivity, MemoActivity::class.java).apply {
                    startActivity(this)
                }
            }

            layoutMemoEditCategory.setOnClickListener {
                setBottomSheet()
            }
//            memoBold.setOnClickListener {
//todo 메모 볼드체 등 기타 버튼에 대한 설정 필요
//            }

            etMemoEditContents.addTextChangedListener {
                setButtonEnable()
            }
            etMemoEditTitle.addTextChangedListener {
                setButtonEnable()
            }
        }
    }

    private fun initAdapter() {
        categoryAdapter = MemoCategorySelectAdapter(
            this,
            selectedCategory = selectCategory,
            itemClick = createCategorySelectListener()
        )
        binding.includeBottomSheetMemoEdit.rcvMemoCategorySelect.adapter = categoryAdapter

        viewModel.categoryList.observe(this) { categoryList ->
            categoryAdapter.setCategoryList(categoryList)
        }
    }

    private fun createCategorySelectListener(): (String) -> Unit {
        return { selectedCategory ->
            selectCategory = selectedCategory
            binding.tvMemoEditCategoryName.text = selectCategory
            initAdapter()
        }
    }

    private fun setBottomSheet() {
        binding.layoutMemoEditCategorySelectDim.visibility = View.VISIBLE
        binding.layoutMemoEditBottomSheet.visibility = View.VISIBLE
        binding.includeBottomSheetMemoEdit.ibMemoCategorySelectCancel.setOnClickListener {
            binding.layoutMemoEditCategorySelectDim.visibility = View.INVISIBLE
            binding.layoutMemoEditBottomSheet.visibility = View.INVISIBLE
        }
    }

    private fun setButtonEnable() {
        binding.run {
            btnMemoEditEnroll.isEnabled =
                etMemoEditTitle.text.isNotEmpty() && etMemoEditContents.text.isNotEmpty()
        }
    }

    companion object {
        const val MARGIN_BOTTOM_SHEET = 94
    }
}