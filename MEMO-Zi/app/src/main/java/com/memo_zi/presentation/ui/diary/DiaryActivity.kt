package com.memo_zi.presentation.ui.diary

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
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

            ivDiaryWritingCamera.setOnClickListener {
                val permission = Manifest.permission.CAMERA
                if (ContextCompat.checkSelfPermission(
                        this@DiaryActivity,
                        permission
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    ActivityCompat.requestPermissions(
                        this@DiaryActivity,
                        arrayOf(permission),
                        PERMISSION_CAMERA_CODE
                    )
                } else {
                    // TODO 권한이 이미 부여되어 있음. 카메라 로직 실행
                }
            }

            ivDiaryWritingAlbum.setOnClickListener {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    val permission = Manifest.permission.READ_MEDIA_IMAGES
                    if (ContextCompat.checkSelfPermission(
                            this@DiaryActivity,
                            permission
                        ) != PackageManager.PERMISSION_GRANTED
                    ) {
                        ActivityCompat.requestPermissions(
                            this@DiaryActivity,
                            arrayOf(permission),
                            PERMISSION_READ_MEDIA_IMAGES_CODE
                        )
                    } else {
                        // TODO 권한이 이미 부여되어 있음. 사진 선택 로직 실행
                    }
                } else {
                    val permission = Manifest.permission.READ_EXTERNAL_STORAGE
                    if (ContextCompat.checkSelfPermission(
                            this@DiaryActivity,
                            permission
                        ) != PackageManager.PERMISSION_GRANTED
                    ) {
                        ActivityCompat.requestPermissions(
                            this@DiaryActivity,
                            arrayOf(permission),
                            PERMISSION_READ_EXTERNAL_STORAGE_CODE
                        )
                    } else {
                        // TODO 권한이 이미 부여되어 있음. 사진 선택 로직 실행
                    }
                }

            }
        }
    }

    private fun initLayout() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fcv_diary)
        if (currentFragment == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fcv_diary, DiaryFeedFragment())
                .commit()
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

    companion object {
        const val DIARY_FEED = "DiaryFeed"
        const val DIARY_CALENDAR = "DiaryCalendar"
        const val PERMISSION_CAMERA_CODE = 800
        const val PERMISSION_READ_EXTERNAL_STORAGE_CODE = 900
        const val PERMISSION_READ_MEDIA_IMAGES_CODE = 933
    }
}
