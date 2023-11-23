package com.memo_zi.ui.login

import android.app.Application
import com.kakao.sdk.common.KakaoSdk
import com.memo_zi.R

class GlobalApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        KakaoSdk.init(this, getString(R.string.kakao_app_key))
    }
}