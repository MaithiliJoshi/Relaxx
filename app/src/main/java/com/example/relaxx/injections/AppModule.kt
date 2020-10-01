package com.example.relaxx.injections

import android.app.Application
import android.os.Build
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun versionCode(application: Application) = application.applicationContext.run {
        val pInfo = packageManager.getPackageInfo(
            packageName,
            0
        )
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P)
            pInfo.longVersionCode
        else pInfo.versionCode.toLong()
    }

    @Provides
    fun moshi() = Moshi.Builder().build()

}
