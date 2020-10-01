package com.example.relaxx.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.relaxx.MainActivity
import com.example.relaxx.repositories.MusicRepository
import com.squareup.moshi.Moshi
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class HomeViewModel : ViewModel() {

    val compositeDisposable = CompositeDisposable()

    @Inject
    lateinit var moshi: Moshi

    @Inject
    lateinit var musicRepository: MusicRepository

    init {
        MainActivity.mainComponent?.inject(this)
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
}