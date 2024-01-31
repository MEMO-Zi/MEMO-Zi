package com.memo_zi.presentation.model

sealed class MemoSearchFeedItem {
    data class Title(
        val titleText: String,
        val amount: Int
    ) : MemoSearchFeedItem()

    data class AllFeedItem(
        val titleText: String,
        val date: String,
        val content: String
    ) : MemoSearchFeedItem()
}