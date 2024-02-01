package com.memo_zi.presentation.ui.memo

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.memo_zi.R
import com.memo_zi.databinding.FragmentMemoSearchBinding
import com.memo_zi.presentation.ui.memo.adapter.MemoSearchAdapter
import com.memo_zi.util.binding.BindingFragment

class MemoSearchFragment :
    BindingFragment<FragmentMemoSearchBinding>(R.layout.fragment_memo_search) {
    private val viewModel by viewModels<MemoSearchViewModel>()
    private lateinit var memoSearchAdapter: MemoSearchAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        setMemoList()
    }

    private fun initAdapter() {
        memoSearchAdapter = MemoSearchAdapter(requireContext())
        binding.rvMemoSearch.adapter = memoSearchAdapter
    }

    private fun setMemoList() {
        viewModel.memoList.observe(viewLifecycleOwner) { memoList ->
            memoSearchAdapter.setMemoList(memoList)
        }
    }

}