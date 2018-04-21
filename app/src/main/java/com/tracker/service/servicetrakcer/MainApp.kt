package com.tracker.service.servicetrakcer

import android.app.Application
import org.koin.android.ext.android.startKoin

class MainApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(AppModule()))
    }
}