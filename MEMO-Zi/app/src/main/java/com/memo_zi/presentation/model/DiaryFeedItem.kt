package com.memo_zi.presentation.model

sealed class DiaryFeedItem {
    data class Title(
        val titleLogoImage: Int
    ) : DiaryFeedItem()

    data class AllFeedItem(
        val diaryDate: String,
        val diaryContent: String,
        val diaryImgUrl: Int,
        val diaryLocation: String,
    ) : DiaryFeedItem()
}
