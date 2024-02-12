package com.memo_zi.presentation.ui.auth

import android.Manifest
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.core.app.ActivityCompat
import com.memo_zi.R
import com.memo_zi.databinding.ActivityAuthBinding
import com.memo_zi.presentation.ui.onboarding.OnboardingActivity
import com.memo_zi.util.binding.BindingActivity
import com.memo_zi.util.component.TextGradation

class AuthActivity : BindingActivity<ActivityAuthBinding>(R.layout.activity_auth) {
    private val permissionList = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        arrayOf(
            Manifest.permission.CAMERA,
            Manifest.permission.READ_MEDIA_IMAGES,
        )
    } else {
        arrayOf(
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE,
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initLayout()
    }

    private fun initLayout() {
        ActivityCompat.requestPermissions(this, permissionList, REQUEST_CODE_PERMISSIONS)

        binding.run {
            TextGradation(
                tvAuthTitle,
                getString(R.string.app_name),
                getColor(R.color.main_pink),
                getColor(R.color.main_purple)
            )
            btnAuthKakao.setOnClickListener {
                navigateToOnboarding()
            }
        }
    }

    private fun navigateToOnboarding() {
        Intent(this, OnboardingActivity::class.java).apply {
            startActivity(this)
        }
        finish()
    }

    companion object {
        const val REQUEST_CODE_PERMISSIONS = 0
    }
}