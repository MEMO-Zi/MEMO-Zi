package com.memo_zi.ui.memo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.memo_zi.databinding.FragmentMemoMainBinding
import com.memo_zi.util.base.BaseFragment

class MemoMainFragment : BaseFragment<FragmentMemoMainBinding>() {
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMemoMainBinding = FragmentMemoMainBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}