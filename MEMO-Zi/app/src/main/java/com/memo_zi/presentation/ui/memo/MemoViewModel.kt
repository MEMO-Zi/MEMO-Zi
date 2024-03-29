package com.memo_zi.presentation.ui.memo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.memo_zi.R
import com.memo_zi.data.model.MemoItem

class MemoViewModel : ViewModel() {
    private val _memoList = MutableLiveData<List<MemoItem>>()
    private val _categoryList = MutableLiveData<List<MemoItem>>()
    val categoryList = _categoryList
    val memoList = _memoList

    init {
        _categoryList.value = listOf(
            MemoItem.Category(
                R.drawable.ic_launcher_background, "투두리스트"
            ),
            MemoItem.Category(
                R.drawable.ic_launcher_background, "하기싫은것"
            ),
            MemoItem.Category(
                R.drawable.ic_launcher_background, "해야만하는것"
            ),
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
            ),
            MemoItem.Memo(
                "교통요금 빠져나가는날",
                "하루정도는 계획없는 날이 있는게 진정한 힙 아닐까? 그냥 한번 써보는말 밥도 안정하고 길가다가 맛있어보이는 집에 들어가면 좋을거 같아 그리고 알람 안맞추고 낮잠을 조금 자고 나",
                "2023-01-10"
            ),
            MemoItem.Memo(
                "오늘은 회의날! ",
                "혜빈이가 맛있는걸 만들어줫다 어제가 발렌타인데이라구... 너무 고맙다 행복하다 최고다 우리의 디자이너",
                "2023-02-15"
            ),
            MemoItem.Memo(
                "교통요금 빠져나가는날",
                "하루정도는 계획없는 날이 있는게 진정한 힙 아닐까? 그냥 한번 써보는말 밥도 안정하고 길가다가 맛있어보이는 집에 들어가면 좋을거 같아 그리고 알람 안맞추고 낮잠을 조금 자고 나",
                "2023-01-10"
            ),
            MemoItem.Memo(
                "교통요금 빠져나가는날",
                "하루정도는 계획없는 날이 있는게 진정한 힙 아닐까? 그냥 한번 써보는말 밥도 안정하고 길가다가 맛있어보이는 집에 들어가면 좋을거 같아 그리고 알람 안맞추고 낮잠을 조금 자고 나",
                "2023-01-10"
            ),
            MemoItem.Memo(
                "교통요금 빠져나가는날",
                "하루정도는 계획없는 날이 있는게 진정한 힙 아닐까? 그냥 한번 써보는말 밥도 안정하고 길가다가 맛있어보이는 집에 들어가면 좋을거 같아 그리고 알람 안맞추고 낮잠을 조금 자고 나",
                "2023-01-10"
            ),
            MemoItem.Memo(
                "교통요금 빠져나가는날",
                "하루정도는 계획없는 날이 있는게 진정한 힙 아닐까? 그냥 한번 써보는말 밥도 안정하고 길가다가 맛있어보이는 집에 들어가면 좋을거 같아 그리고 알람 안맞추고 낮잠을 조금 자고 나",
                "2023-01-10"
            ),
        )
    }
}