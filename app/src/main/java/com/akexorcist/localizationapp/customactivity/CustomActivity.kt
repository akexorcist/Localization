package com.akexorcist.localizationapp.customactivity

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import com.akexorcist.localizationactivity.core.LocalizationActivityDelegate
import com.akexorcist.localizationactivity.core.OnLocaleChangedListener
import java.util.*

open class CustomActivity : Activity(), OnLocaleChangedListener {
    private val localizationDelegate = LocalizationActivityDelegate(this)

    public override fun onCreate(savedInstanceState: Bundle?) {
        localizationDelegate.addOnLocaleChangedListener(this)
        localizationDelegate.onCreate()
        super.onCreate(savedInstanceState)
    }

    public override fun onResume() {
        super.onResume()
        localizationDelegate.onResume(this)
    }

    override fun attachBaseContext(newBase: Context) {
        applyOverrideConfiguration(localizationDelegate.updateConfigurationLocale(newBase))
        super.attachBaseContext(newBase)
    }

    override fun getApplicationContext(): Context {
        return localizationDelegate.getApplicationContext(super.getApplicationContext())
    }

    override fun getResources(): Resources {
        return localizationDelegate.getResources(super.getResources())
    }

    fun setLanguage(language: String?) {
        localizationDelegate.setLanguage(this, language!!)
    }

    fun setLanguage(locale: Locale?) {
        localizationDelegate.setLanguage(this, locale!!)
    }

    val currentLanguage: Locale
        get() = localizationDelegate.getLanguage(this)

    // Just override method locale change event
    override fun onBeforeLocaleChanged() {}
    override fun onAfterLocaleChanged() {}
}
