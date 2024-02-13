package com.memo_zi.util.component

import android.content.Context
import android.widget.TextView
import androidx.core.text.set
import androidx.core.text.toSpannable

class TextGradation(
    context: Context,
    textView: TextView,
) {
    init {
        val spannable = textView.text.toSpannable()
        spannable[START_INDEX..textView.text.toString().length] = LinearGradientSpan(
            context = context,
            containingText = textView.text.toString(),
            textToStyle = textView.text.toString()
                .substring(START_INDEX, textView.text.toString().length)
        )
        textView.text = spannable
    }

    companion object {
        const val START_INDEX = 0
    }
}
