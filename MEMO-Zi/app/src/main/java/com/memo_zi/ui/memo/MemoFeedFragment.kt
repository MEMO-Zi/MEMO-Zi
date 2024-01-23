package com.memo_zi.ui.memo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.hadi.viewpager2carousel.MemoAdapter
import com.memo_zi.databinding.FragementMemoFeedBinding
import com.memo_zi.util.binding.BindingFragment

class MemoFeedFragment : BindingFragment<FragementMemoFeedBinding>() {
    private val viewModel by viewModels<MemoViewModel>()
    private lateinit var memoAdapter: MemoAdapter

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragementMemoFeedBinding = FragementMemoFeedBinding.inflate(inflater, container, false)

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