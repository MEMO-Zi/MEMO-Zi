package com.memo_zi.util.text

import android.graphics.Typeface
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan

class TextviewSetting {
    fun setTextBold(string: String): SpannableStringBuilder {
        val boldText = SpannableStringBuilder(string)
        boldText.setSpan(
            StyleSpan(Typeface.BOLD),
            0,
            string.length,
            SpannableString.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        return boldText
    }

    fun text(string: String): SpannableStringBuilder {
        return SpannableStringBuilder(string)
    }

    fun addText(
        span1: SpannableStringBuilder,
        span2: SpannableStringBuilder
    ): SpannableStringBuilder {
        return span1.append(span2)
    }

}