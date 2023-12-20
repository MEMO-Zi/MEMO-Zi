package com.memo_zi.ui.diary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.memo_zi.databinding.FragmentCalendarBottomSheetBinding
import com.memo_zi.util.binding.BindingBottomSheetDialogFragment

class CalendarBottomSheetFragment :
    BindingBottomSheetDialogFragment<FragmentCalendarBottomSheetBinding>() {
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCalendarBottomSheetBinding =
        FragmentCalendarBottomSheetBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}