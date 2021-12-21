package com.akexorcist.localizationactivity.ui

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import com.akexorcist.localizationactivity.core.LocalizationApplicationDelegate
import java.util.*

abstract class LocalizationApplication : Application() {
    private val localizationDelegate = LocalizationApplicationDelegate()

    override fun attachBaseContext(base: Context) {
        localizationDelegate.setDefaultLanguage(base, getDefaultLanguage(base))
        super.attachBaseContext(localizationDelegate.attachBaseContext(base))
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        localizationDelegate.onConfigurationChanged(this)
    }

    override fun getApplicationContext(): Context {
        return localizationDelegate.getApplicationContext(super.getApplicationContext())
    }

    override fun getResources(): Resources {
        return localizationDelegate.getResources(this, super.getResources())
    }

    abstract fun getDefaultLanguage(context: Context): Locale
}
