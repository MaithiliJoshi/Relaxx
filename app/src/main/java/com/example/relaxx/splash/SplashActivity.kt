package com.example.relaxx.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.example.relaxx.BaseActivity
import com.example.relaxx.MainActivity
import com.example.relaxx.R
import com.example.relaxx.Relaxx

class
SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onStart() {
        super.onStart()
        Relaxx.appComponent.inject(this)
        Handler().postDelayed(
            {
                startMainActivity()
            }
            , 1000
        )
    }

    private fun startMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
