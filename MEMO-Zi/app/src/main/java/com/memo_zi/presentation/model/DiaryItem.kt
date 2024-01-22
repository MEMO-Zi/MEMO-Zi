package com.memo_zi.presentation.model

sealed class DiaryItem() {
    data class Title(
        val titleLogoImage: Int
    ) : DiaryItem()

    data class AllItem(
        val diaryDate: String,
        val diaryContent: String,
        val diaryImgUrl: Int,
        val diaryLocation: String,
    ) : DiaryItem()
}
