package com.memo_zi.data.model

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

//    data class TextItem(
//        val diaryDate: String,
//        val diaryContent: String,
//    ) : DiaryItem()
//    data class ImageItem(
//        val diaryDate: String,
//        val diaryContent: String,
//        val diaryImgUrl: String,
//    ) : DiaryItem()
//    data class LocationItem(
//        val diaryDate: String,
//        val diaryContent: String,
//        val diaryLocation: String,
//    ) : DiaryItem()
}
