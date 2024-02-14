package com.memo_zi.util.component

import android.content.Context
import android.graphics.LinearGradient
import android.graphics.Shader
import android.text.TextPaint
import android.text.style.CharacterStyle
import android.text.style.UpdateAppearance
import androidx.annotation.ColorInt
import androidx.core.graphics.toColor
import androidx.core.graphics.toColorLong
import com.memo_zi.R
import com.memo_zi.util.ext.colorOf

class LinearGradientSpan(
    private val context: Context,
    private val containingText: String,
    private val textToStyle: String,

    ) : CharacterStyle(), UpdateAppearance {

    override fun updateDrawState(tp: TextPaint?) {
        @ColorInt val startColorInt = context.getColor(R.color.main_pink)
        @ColorInt val endColorInt = context.getColor(R.color.main_purple)
        tp ?: return

        var leadingHeight = 0f
        val indexOfTextToStyle = containingText.indexOf(textToStyle)
        if (!containingText.startsWith(textToStyle) && containingText != textToStyle) {
            leadingHeight = tp.ascent() + tp.descent() * indexOfTextToStyle
        }
        val gradientHeight = tp.descent() - tp.ascent()
        tp.shader = LinearGradient(
            START_INDEX,
            leadingHeight,
            START_INDEX,
            leadingHeight + gradientHeight,
            startColorInt,
            endColorInt,
            Shader.TileMode.REPEAT
        )
    }

    companion object {
        const val START_INDEX = 0f
    }
}