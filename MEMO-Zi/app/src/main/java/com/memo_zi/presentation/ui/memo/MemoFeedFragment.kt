package com.memo_zi.presentation.ui.memo

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.memo_zi.presentation.ui.memo.adapter.MemoAdapter
import com.memo_zi.R
import com.memo_zi.databinding.FragmentMemoFeedBinding
import com.memo_zi.util.binding.BindingFragment

class MemoFeedFragment : BindingFragment<FragmentMemoFeedBinding>(R.layout.fragment_memo_feed) {
    private val viewModel by viewModels<MemoViewModel>()
    private lateinit var memoAdapter: MemoAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        setMemoList()
    }

    private fun initAdapter() {
        memoAdapter = MemoAdapter(requireContext())
        binding.rvMemo.adapter = memoAdapter
    }

    private fun setMemoList() {
        viewModel.memoList.observe(viewLifecycleOwner) { memoList ->
            memoAdapter.setMemoList(memoList)
        }
    }

}