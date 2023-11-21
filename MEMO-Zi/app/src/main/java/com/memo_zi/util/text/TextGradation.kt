package com.memo_zi.util.text

import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.core.text.set
import androidx.core.text.toSpannable

class TextGradation (
    textView: TextView,
    text: String,
    @ColorInt startColorInt: Int,
    @ColorInt endColorInt: Int,
    startIndex: Int = 0,
    endIndex: Int = text.length
) {
    init {
        val spannable = text.toSpannable()
        spannable[startIndex..endIndex] = LinearGradientSpan(text, text.substring(startIndex, endIndex), startColorInt, endColorInt)
        textView.text = spannable
    }
}
