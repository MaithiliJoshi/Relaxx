package com.example.relaxx.injections

import android.app.Application
import com.example.relaxx.repositories.MusicRepository
import com.example.relaxx.splash.SplashActivity
import com.squareup.moshi.Moshi
import dagger.BindsInstance
import dagger.Component
import retrofit2.Retrofit

@Component(
    modules = [
        AppModule::class,
        NetworkModule::class
    ]
)
interface ApplicationComponent {
    /**
     * this exports retrofit to the dependents
     */
    fun retroFit(): Retrofit
    fun moshi(): Moshi

    fun inject(splashActivity: SplashActivity)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }
}