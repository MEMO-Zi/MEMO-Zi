package com.memo_zi.presentation.ui.memo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.memo_zi.presentation.model.MemoSearchFeedItem
import javax.inject.Inject

class MemoSearchViewModel @Inject constructor(

) :ViewModel() {
    private val _memoList = MutableLiveData<List<MemoSearchFeedItem>>()
    val memoList = _memoList

    //더미데이터 테스트
    init {
        _memoList.value = listOf(
            MemoSearchFeedItem.Title("투두리스트",2),
            MemoSearchFeedItem.AllFeedItem(
                "오늘의 할일",
                "2023-01-30",
                "메모지 회의!"
            ),
            MemoSearchFeedItem.AllFeedItem(
                "오늘의 할일",
                "2023-01-31",
                "어려운것...서치뷰 만들기"
            )

        )

    }

}
