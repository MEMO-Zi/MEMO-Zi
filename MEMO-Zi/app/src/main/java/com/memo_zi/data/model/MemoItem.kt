package com.memo_zi.data.model

sealed class MemoItem {
    data class Category(
        val imageRes: Int,
        val title: String
    ): MemoItem()
    data class Memo(
        val title: String,
        val contents: String,
        val date: String
    ) : MemoItem()
}