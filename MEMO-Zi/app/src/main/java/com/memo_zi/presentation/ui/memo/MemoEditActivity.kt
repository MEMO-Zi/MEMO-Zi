package com.memo_zi.presentation.ui.memo

import android.content.Intent
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.memo_zi.R
import com.memo_zi.databinding.ActivityMemoEditBinding
import com.memo_zi.util.binding.BindingActivity


class MemoEditActivity : BindingActivity<ActivityMemoEditBinding>(R.layout.activity_memo_edit) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initLayout()
    }

    private fun initLayout() {
        setupButton()
        setButtonEnable()
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

    private fun setBottomSheet() {
        val bottomSheetView =
            layoutInflater.inflate(R.layout.bottom_sheet_memo_category_select, null)
        val bottomSheetDialog = BottomSheetDialog(this@MemoEditActivity)
        val offsetFromTop = MARGIN_BOTTOM_SHEET
        (bottomSheetDialog as? BottomSheetDialog)?.behavior?.apply {
            isFitToContents = false
            expandedOffset = offsetFromTop
            state = BottomSheetBehavior.STATE_EXPANDED
        }
        bottomSheetDialog.setContentView(bottomSheetView)
        bottomSheetDialog.show()
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