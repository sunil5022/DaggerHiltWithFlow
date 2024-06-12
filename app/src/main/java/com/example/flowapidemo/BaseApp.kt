package com.example.flowapidemo

import android.app.Application
import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApp : MultiDexApplication() {

}