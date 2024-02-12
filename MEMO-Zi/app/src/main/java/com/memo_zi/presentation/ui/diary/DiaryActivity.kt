package com.memo_zi.presentation.ui.diary

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import coil.load
import com.memo_zi.R
import com.memo_zi.databinding.ActivityDiaryBinding
import com.memo_zi.presentation.ui.memo.MemoActivity
import com.memo_zi.presentation.ui.setting.SettingActivity
import com.memo_zi.util.binding.BindingActivity
import com.memo_zi.util.component.TextGradation
import com.memo_zi.util.ext.colorOf
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DiaryActivity :
    BindingActivity<ActivityDiaryBinding>(R.layout.activity_diary) {
    private val viewModel by viewModels<DiaryViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initLayout()
        addListeners()
    }

    private fun initLayout() {
        initFragment()
        initWritingTextCount()
    }

    private fun addListeners() {
        clickToChangeActivity()
        clickToChangeFragment()
        clickToWritingLayout()
        clickToWritingIcon()
    }

    private fun initFragment() {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fcv_diary)
        if (currentFragment == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fcv_diary, DiaryFeedFragment())
                .commit()
        }
    }

    private fun initWritingTextCount() {
        TextGradation(
            textView = binding.tvDiaryWritingCount,
            text = "100",
            startColorInt = colorOf(R.color.main_pink),
            endColorInt = colorOf(R.color.main_purple)
        )

        binding.etDiaryWriting.addTextChangedListener { text ->
            binding.tvDiaryWritingCount.text = (100 - (text?.length ?: 0)).toString()
        }
    }

    private fun clickToChangeActivity() {
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
    }

    private fun clickToWritingLayout() {
        with(binding) {
            layoutDiaryDefault.setOnClickListener {
                layoutDiaryDefault.visibility = View.GONE
                layoutDiaryWriting.visibility = View.VISIBLE
            }
        }
    }

    private fun clickToChangeFragment() {
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
        }
    }

    private fun clickToWritingIcon() {
        binding.ivDiaryWritingCamera.setOnClickListener {
            clickToCamera()
        }

        binding.ivDiaryWritingAlbum.setOnClickListener {
            clickToAlbum()
        }

        binding.ivDiaryWritingX.setOnClickListener {
            binding.ivDiaryWriting.visibility = View.GONE
            binding.ivDiaryWritingX.visibility = View.GONE
            // TODO 서버 통신으로 넘기는 이미지 값 삭제
        }
    }

    private fun clickToCamera() {
        val permissionCheck = ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.CAMERA
        )
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            startCameraActivity()
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CAMERA),
                PERMISSION_CAMERA_CODE
            )
        }
    }

    private val takePictureLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                val imageBitmap: Bitmap? = data?.extras?.getParcelable("data")
                with(binding) {
                    ivDiaryWriting.visibility = View.VISIBLE
                    ivDiaryWritingX.visibility = View.VISIBLE
                    ivDiaryWriting.load(imageBitmap)
                }
            }
        }

    private fun startCameraActivity() {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        if (takePictureIntent.resolveActivity(packageManager) != null) {
            takePictureLauncher.launch(takePictureIntent)
        }
    }

    private fun clickToAlbum() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            val permissionCheck = ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_MEDIA_IMAGES
            )
            if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
                openAlbum()
            } else {
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
                openAlbum()
            } else {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                    PERMISSION_READ_EXTERNAL_STORAGE_CODE
                )
            }
        }
    }

    private val pickImage = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        if (uri != null) {
            binding.ivDiaryWriting.visibility = View.VISIBLE
            binding.ivDiaryWritingX.visibility = View.VISIBLE
            binding.ivDiaryWriting.load(uri)
        }
    }

    private fun openAlbum() {
        pickImage.launch("image/*")
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
