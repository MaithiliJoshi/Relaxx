package com.example.relaxx.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import com.example.relaxx.BaseActivity
import com.example.relaxx.MainActivity
import com.example.relaxx.R
import com.example.relaxx.Relaxx
import kotlinx.android.synthetic.main.activity_splash.*

class
SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        imageView1.animation = AnimationUtils.loadAnimation(this, R.anim.splash_anim)
    }

    override fun onStart() {
        super.onStart()
        Relaxx.appComponent.inject(this)
        Handler().postDelayed(
            {
                startMainActivity()
            }
            , 2000
        )
    }

    private fun startMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
