package com.memo_zi.presentation.ui.diary

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.memo_zi.R
import com.memo_zi.presentation.model.DiaryFeedItem
import javax.inject.Inject

class DiaryViewModel @Inject constructor(

) : ViewModel() {
    private val _diaryList = MutableLiveData<List<DiaryFeedItem>>()
    val diaryList get() = _diaryList

    // 더미데이터 테스트
    init {
        _diaryList.value = listOf(
            DiaryFeedItem.Title(R.drawable.ic_launcher_background),
            DiaryFeedItem.AllFeedItem(
                "2023년 12월 19일 | 화요일",
                "일본?????????? 거기가 어딘데",
                R.drawable.ic_launcher_background,
                "일본 교토시"
            ),
            DiaryFeedItem.AllFeedItem(
                "2023년 12월 18일 | 월요일",
                "삿포로 맥주축제",
                R.drawable.ic_launcher_background,
                "일본 삿포로"
            ),
            DiaryFeedItem.AllFeedItem(
                "2023년 12월 17일 | 일요일",
                "베트남은 사파지~",
                R.drawable.ic_launcher_background,
                "베트남 사파"
            ),
            DiaryFeedItem.AllFeedItem(
                "2023년 12월 16일 | 토요일",
                "포항항항~",
                R.drawable.ic_launcher_background,
                "대한민국 포항"
            ),
            DiaryFeedItem.AllFeedItem(
                "2023년 12월 15일 | 금요일",
                "예??????????? 여행이 뭐죠",
                R.drawable.ic_launcher_background,
                "여행안감(추후 안보이도록 수정)"
            ),
            DiaryFeedItem.AllFeedItem(
                "2023년 12월 14일 | 목요일",
                "한국은 서울이지 ㅎ",
                R.drawable.ic_launcher_background,
                "대한민국 서울"
            ),
        )
    }
}