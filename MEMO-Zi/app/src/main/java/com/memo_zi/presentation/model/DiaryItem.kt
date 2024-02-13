package com.memo_zi.presentation.model

sealed class DiaryItem {
    data class FeedTitle(
        val titleLogoImage: Int
    ) : DiaryItem()

    data class Item(
        val diaryDate: String,
        val diaryContent: String,
        val diaryImgUrl: Int,
        val diaryLocation: String,
    ) : DiaryItem()
}
