package com.memo_zi.presentation.ui.memo

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.memo_zi.R
import com.memo_zi.databinding.FragmentMemoCategoryEditBinding
import com.memo_zi.presentation.ui.memo.adapter.MemoCategoryAdapter
import com.memo_zi.util.binding.BindingFragment

class MemoCategoryFragment :
    BindingFragment<FragmentMemoCategoryEditBinding>(R.layout.fragment_memo_category_edit) {
    private val viewModel by viewModels<MemoViewModel>()
    private lateinit var categoryAdapter: MemoCategoryAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        setCategory()
    }

    private fun initAdapter() {
        categoryAdapter = MemoCategoryAdapter(requireContext())
//todo 카테고리 화면으로 변환시 viewpager에서 선택된  아이템 넘기기
    }

    private fun setCategory() {
        viewModel.memoList.observe(viewLifecycleOwner) { memoList ->
            categoryAdapter.setCategoryList(memoList)
        }
    }

}