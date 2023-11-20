package com.memo_zi.ui.login

import android.graphics.LinearGradient
import android.graphics.Shader
import android.text.TextPaint
import android.text.style.CharacterStyle
import android.text.style.UpdateAppearance
import androidx.annotation.ColorInt

class LinearGradientSpan(
    private val containingText: String,
    private val textToStyle: String,
    @ColorInt private val startColorInt: Int,
    @ColorInt private val endColorInt: Int
) : CharacterStyle(), UpdateAppearance {

    override fun updateDrawState(tp: TextPaint?) {
        tp ?: return

        var leadingHeight = 0f
        val indexOfTextToStyle = containingText.indexOf(textToStyle)
        if (!containingText.startsWith(textToStyle) && containingText != textToStyle) {
            leadingHeight = tp.fontSpacing * indexOfTextToStyle
        }
        val gradientHeight = tp.fontSpacing * textToStyle.length

        tp.shader = LinearGradient(
            0f,
            leadingHeight,
            0f,
            leadingHeight + gradientHeight,
            startColorInt,
            endColorInt,
            Shader.TileMode.REPEAT
        )
    }
}