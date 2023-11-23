package com.memo_zi.ui.login

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import com.kakao.sdk.auth.AuthCodeClient
import com.kakao.sdk.common.KakaoSdk
import com.kakao.sdk.common.util.Utility
import com.memo_zi.R
import com.memo_zi.ui.home.HomeActivity
import com.memo_zi.util.text.TextGradation

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        TextGradation(
            findViewById(R.id.logoText),
            getString(R.string.app_name),
            ContextCompat.getColor(this, R.color.bg_start),
            ContextCompat.getColor(this, R.color.bg_end)
        )

        //todo 추후 스플래쉬 화면에서 init하도록 할것 단한번만 호출되어야함 sdk

        val keyHash = Utility.getKeyHash(this)
        Log.d("Hash", keyHash)

    }

}
