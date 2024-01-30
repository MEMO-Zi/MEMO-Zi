package com.memo_zi.util.component

import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.google.android.material.snackbar.Snackbar
import com.memo_zi.databinding.ViewCustomSnackbarBinding
import com.memo_zi.util.ext.toPx

object CustomSnackbar {
    private const val MARGIN_PX = 8

    fun makeSnackbar(view: View, message: String, botMarin: Int) {
        val inflater = LayoutInflater.from(view.context)
        val binding = ViewCustomSnackbarBinding.inflate(inflater, null, false)

        binding.tvSnackbar.text = message

        val snackbar = Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
        val snackbarLayout = snackbar.view as ViewGroup

        val layoutParams = snackbarLayout.layoutParams as FrameLayout.LayoutParams

        snackbarLayout.layoutParams = layoutParams.apply {
            width = ViewGroup.LayoutParams.MATCH_PARENT
            height = ViewGroup.LayoutParams.WRAP_CONTENT
            gravity = Gravity.CENTER_HORIZONTAL or Gravity.BOTTOM
            bottomMargin = botMarin.toPx()
            marginStart = MARGIN_PX.toPx()
            marginEnd = MARGIN_PX.toPx()
        }

        with(snackbarLayout) {
            removeAllViews()
            setPadding(0, 0, 0, 0)
            addView(binding.root)
        }

        snackbar.show()
    }
}