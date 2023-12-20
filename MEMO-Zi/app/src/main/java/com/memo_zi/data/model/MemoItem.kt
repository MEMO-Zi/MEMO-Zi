package com.memo_zi.data.model

sealed class MemoItem {
    data class CateGory(
        val categoryImgURL: Int,
        val text: String,
        val listMemo: List<Memo>
    ) : MemoItem()

    data class Memo(
        val title: String,
        val text: String
    ) : MemoItem()


}