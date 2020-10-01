package com.example.relaxx.ui.home

import com.example.relaxx.repositories.MusicRepository
import com.example.relaxx.services.MusicService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class MainModule {

    @Provides
    fun musicService(retrofit: Retrofit) = retrofit.create(MusicService::class.java)

    @Provides
    fun musicRepository(musicService: MusicService) = MusicRepository(musicService)
}