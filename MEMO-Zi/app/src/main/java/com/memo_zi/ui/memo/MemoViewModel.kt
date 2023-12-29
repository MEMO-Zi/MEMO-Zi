package com.memo_zi.ui.memo
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.memo_zi.R
import com.memo_zi.data.model.DiaryItem
import com.memo_zi.data.model.MemoCategory

class MemoViewModel : ViewModel() {
    private val _categoryList = MutableLiveData<List<MemoCategory>>()
    init {
        _categoryList.value = listOf(
            MemoCategory(R.drawable.img_category, "투두리스트"),
            MemoCategory(R.drawable.img_category2, "하기싫은것"),
            MemoCategory(R.drawable.img_category, "해야만하는것")
        )
    }
}