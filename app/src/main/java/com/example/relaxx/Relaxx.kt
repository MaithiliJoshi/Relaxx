package com.example.relaxx

import android.app.Application
import com.example.relaxx.injections.ApplicationComponent
import com.example.relaxx.injections.DaggerApplicationComponent

class Relaxx : Application() {

    companion object {
        lateinit var appComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.builder().application(this).build()

    }
}