package com.sammy.jetpackcompose

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import de.hdodenhof.circleimageview.BuildConfig
import timber.log.Timber

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}