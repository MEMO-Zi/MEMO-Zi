package com.memo_zi.ui.memo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.memo_zi.R
import com.memo_zi.data.model.DiaryItem
import com.memo_zi.data.model.MemoCategory
import com.memo_zi.data.model.MemoItem

class MemoViewModel : ViewModel() {
    private val _categoryList = MutableLiveData<List<MemoCategory>>()

    private val _memoList = MutableLiveData<List<MemoItem>>()

    init {
        _categoryList.value = listOf(
            MemoCategory(R.drawable.img_category, "투두리스트"),
            MemoCategory(R.drawable.img_category2, "하기싫은것"),
            MemoCategory(R.drawable.img_category, "해야만하는것")
        )

        _memoList.value = listOf(
            MemoItem.Memo(
                "교통요금 빠져나가는날",
                "하루정도는 계획없는 날이 있는게 진정한 힙 아닐까? 그냥 한번 써보는말 밥도 안정하고 길가다가 맛있어보이는 집에 들어가면 좋을거 같아 그리고 알람 안맞추고 낮잠을 조금 자고 나",
                "2023-01-10"
            ),
            MemoItem.Memo(
                "생일!",
                "기분 좋은 생일날!",
                "2023-01-06"
            )

        )
    }
}