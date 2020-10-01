package com.example.relaxx.injections


import android.app.Application
import com.example.relaxx.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit

@Module
class NetworkModule {

    @Provides
    fun okHttp(application: Application, versionCode: Long): OkHttpClient {

        val client = OkHttpClient()
            .newBuilder()
        return client.build()
    }

    @Provides
    fun retrofit(okHttpClient: OkHttpClient) = Retrofit.Builder()
        .baseUrl("https://github.com")
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(okHttpClient)
        .build()
}