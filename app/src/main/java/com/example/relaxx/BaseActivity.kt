package com.example.relaxx

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.PackageManager.GET_META_DATA
import android.content.res.Configuration
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.pm.PackageInfoCompat
import timber.log.Timber

abstract class BaseActivity : AppCompatActivity() {

    private var originalContext: Context? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        // deleteAll FLAG_TRANSLUCENT_STATUS flag:
        window?.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
//        adjustFontScale(resources.configuration)
    }

//    override fun attachBaseContext(base: Context?) {
//        originalContext = base
//    }

    protected open fun resetTitles() {
        try {
            val info = packageManager.getActivityInfo(componentName, GET_META_DATA)
            if (info.labelRes != 0) {
                setTitle(info.labelRes)
            }
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
    }

    override fun onNewIntent(intent: Intent) {
        try {
            Timber.i("BaseActivity New Intent triggred")
        } catch (t: Throwable) {
            t.printStackTrace()
        }
        super.onNewIntent(intent)
    }


    fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    fun showKeyBoard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.toggleSoftInputFromWindow(view.windowToken, InputMethodManager.SHOW_FORCED, 0)
        }
    }

    fun showKeyBoard(view: View?) {
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(view, InputMethodManager.SHOW_FORCED)
        }
    }

    private fun adjustFontScale(configuration: Configuration) {
        configuration.fontScale = 1.0.toFloat()
        val metrics = resources.displayMetrics
        val wm = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        wm.defaultDisplay.getMetrics(metrics)
        metrics.scaledDensity = configuration.fontScale * metrics.density

        resources.updateConfiguration(configuration, metrics)
    }


    fun getVersionInfo(): String? = try {
        val versionName = packageName ?: ""
        val pInfo = packageManager?.getPackageInfo(versionName, 0)
        var env = ""
        if (BuildConfig.DEBUG) {
            env = " - ${BuildConfig.BUILD_TYPE}"
        }
        getString(R.string.version) + pInfo?.versionName + "(" + pInfo?.let {
            PackageInfoCompat.getLongVersionCode(it)
        } + ")" + env
    } catch (e: PackageManager.NameNotFoundException) {
        e.printStackTrace()
        ""
    }
}