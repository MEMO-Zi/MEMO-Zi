package com.memo_zi

import android.app.Application
import com.memo_zi.util.DebugTree
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()

        setTimber()
    }

    private fun setTimber() {
        if (BuildConfig.DEBUG) Timber.plant(DebugTree())
    }
}