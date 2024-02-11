package com.memo_zi.presentation.ui.diary

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import coil.load
import com.memo_zi.R
import com.memo_zi.databinding.ActivityDiaryBinding
import com.memo_zi.presentation.ui.memo.MemoActivity
import com.memo_zi.presentation.ui.setting.SettingActivity
import com.memo_zi.util.binding.BindingActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DiaryActivity :
    BindingActivity<ActivityDiaryBinding>(R.layout.activity_diary) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initLayout()
        addListeners()
    }

    private fun initLayout() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fcv_diary)
        if (currentFragment == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fcv_diary, DiaryFeedFragment())
                .commit()
        }
    }

    private fun addListeners() {
        binding.includeTopAppbar.ivAllTopAppbarChange.setOnClickListener {
            Intent(this, MemoActivity::class.java).apply {
                startActivity(this)
            }
        }
        binding.includeTopAppbar.ivAllTopAppbarSetting.setOnClickListener {
            Intent(this, SettingActivity::class.java).apply {
                startActivity(this)
            }
        }
        with(binding) {
            ivDiaryChangeFeed.setOnClickListener {
                ivDiaryChangeFeed.setImageResource(R.drawable.ic_feed_select_22)
                ivDiaryChangeCalendar.setImageResource(R.drawable.ic_calender_default_22)
                replaceFragment(DIARY_FEED)
            }

            ivDiaryChangeCalendar.setOnClickListener {
                ivDiaryChangeFeed.setImageResource(R.drawable.ic_feed_default_22)
                ivDiaryChangeCalendar.setImageResource(R.drawable.ic_calender_select_22)
                replaceFragment(DIARY_CALENDAR)
            }

            layoutDiaryDefault.setOnClickListener {
                layoutDiaryDefault.visibility = View.GONE
                layoutDiaryWriting.visibility = View.VISIBLE
            }
        }

        binding.ivDiaryWritingCamera.setOnClickListener {
            clickToCamera()
        }

        binding.ivDiaryWritingAlbum.setOnClickListener {
            clickToAlbum()
        }
    }

    private fun replaceFragment(name: String) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()

        val newFragment = when (name) {
            DIARY_FEED -> DiaryFeedFragment()
            DIARY_CALENDAR -> DiaryCalendarFragment()
            else -> Fragment()
        }
        fragmentTransaction.replace(R.id.fcv_diary, newFragment)
        fragmentTransaction.commit()
    }

    private fun clickToCamera() {
        val permissionCheck = ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.CAMERA
        )
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            // 카메라 실행
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CAMERA),
                PERMISSION_CAMERA_CODE
            )
        }
    }

    private fun clickToAlbum() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            val permissionCheck = ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_MEDIA_IMAGES
            )
            if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
                // 이미 권한이 허용되어 있는 경우
                // 앨범실행
            } else {
                // 권한을 요청
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.READ_MEDIA_IMAGES),
                    PERMISSION_READ_MEDIA_IMAGES_CODE
                )
            }
        } else {
            val permissionCheck = ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE
            )
            if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
                // 이미 권한이 허용되어 있는 경우
                // 앨범실행
            } else {
                // 권한을 요청
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                    PERMISSION_READ_EXTERNAL_STORAGE_CODE
                )
            }
        }
    }

    companion object {
        const val DIARY_FEED = "DiaryFeed"
        const val DIARY_CALENDAR = "DiaryCalendar"
        const val PERMISSION_CAMERA_CODE = 800
        const val PERMISSION_READ_EXTERNAL_STORAGE_CODE = 900
        const val PERMISSION_READ_MEDIA_IMAGES_CODE = 933
    }
}
