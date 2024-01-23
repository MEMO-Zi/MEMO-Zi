package com.memo_zi.ui.login
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.user.UserApiClient
import com.memo_zi.R
import com.memo_zi.databinding.ActivityLoginBinding
import com.memo_zi.util.text.TextGradation

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        textGradation()
        binding.kakaoLoginButton.setOnClickListener {
            kakaoLogin()
        }
    }

    private fun textGradation() {
        TextGradation(
            findViewById(R.id.logoText),
            getString(R.string.app_name),
            ContextCompat.getColor(this, R.color.bg_start),
            ContextCompat.getColor(this, R.color.bg_end)
        )
    }

    private fun kakaoLogin() {
        UserApiClient.instance.accessTokenInfo { tokenInfo, error ->
            if (error != null) {
                Log.e("kakao", "Failed to get token info", error)
                Toast.makeText(this, "토큰 정보 보기 실패", Toast.LENGTH_SHORT).show()
            } else if (tokenInfo != null) {
                Log.d("kakao", "Token info: $tokenInfo")
                Toast.makeText(this, "토큰 정보 보기 성공", Toast.LENGTH_SHORT).show()
                //다음 이동할 액티비티로 전환
                changeActivity()
            }
        }

        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            if (error != null) {
                Log.e("kakao", "카카오계정으로 로그인 실패", error)
            } else if (token != null) {
                Log.i("kakao", "카카오계정으로 로그인 성공 ${token.accessToken}")
                Toast.makeText(this, "카톡로그인", Toast.LENGTH_SHORT).show()
                //다음 이동할 액티비티로 전환
                changeActivity()
            }
        }


        if (UserApiClient.instance.isKakaoTalkLoginAvailable(this)) {
            UserApiClient.instance.loginWithKakaoTalk(this) { token, error ->
                if (error != null) {
                    Log.e("kakao", "카카오톡으로 로그인 실패", error)

                    // 사용자가 카카오톡 설치 후 디바이스 권한 요청 화면에서 로그인을 취소한 경우,
                    // 의도적인 로그인 취소로 보고 카카오계정으로 로그인 시도 없이 로그인 취소로 처리 (예: 뒤로 가기)
                    if (error is ClientError && error.reason == ClientErrorCause.Cancelled) {
                        return@loginWithKakaoTalk
                    }
                    // 카카오톡에 연결된 카카오계정이 없는 경우, 카카오계정으로 로그인 시도
                    UserApiClient.instance.loginWithKakaoAccount(this, callback = callback)
                } else if (token != null) {
                    Toast.makeText(this, "카톡로그인", Toast.LENGTH_SHORT).show()
                    Log.i("kakao", "카카오톡으로 로그인 성공 ${token.accessToken}")
                    changeActivity()
                }
            }
        } else {
            UserApiClient.instance.loginWithKakaoAccount(this, callback = callback)
        }
    }

    private fun changeActivity(){
        Log.d("Debug", "Changing to HomeActivity")
        //val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
        finish()
    }
}

