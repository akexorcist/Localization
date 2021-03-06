package com.akexorcist.localizationactivity.ui

import android.content.Context
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.akexorcist.localizationactivity.core.LocalizationActivityDelegate
import com.akexorcist.localizationactivity.core.OnLocaleChangedListener
import java.util.*

abstract class LocalizationActivity : AppCompatActivity, OnLocaleChangedListener {
    constructor() : super()
    constructor(@LayoutRes contentLayoutId: Int) : super(contentLayoutId)

    private val localizationDelegate: LocalizationActivityDelegate by lazy {
        LocalizationActivityDelegate(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        localizationDelegate.addOnLocaleChangedListener(this)
        localizationDelegate.onCreate()
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        localizationDelegate.onResume(this)
    }

    override fun attachBaseContext(newBase: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            applyOverrideConfiguration(localizationDelegate.updateConfigurationLocale(newBase))
            super.attachBaseContext(newBase)
        } else {
            super.attachBaseContext(localizationDelegate.attachBaseContext(newBase))
        }
    }

    override fun getBaseContext(): Context {
        return localizationDelegate.getApplicationContext(super.getBaseContext())
    }

    override fun getApplicationContext(): Context {
        return localizationDelegate.getApplicationContext(super.getApplicationContext())
    }

    override fun getResources(): Resources {
        return localizationDelegate.getResources(super.getResources())
    }

    override fun onBeforeLocaleChanged() {
        // Just override method locale change event
    }

    override fun onAfterLocaleChanged() {
        // Just override method locale change event
    }

    fun setLanguage(language: String) {
        localizationDelegate.setLanguage(this, language)
    }

    fun setLanguage(language: String, country: String) {
        localizationDelegate.setLanguage(this, language, country)
    }

    fun setLanguage(locale: Locale) {
        localizationDelegate.setLanguage(this, locale)
    }

    fun setLanguageWithoutNotification(language: String) {
        localizationDelegate.setLanguageWithoutNotification(this, language)
    }

    fun setLanguageWithoutNotification(language: String, country: String) {
        localizationDelegate.setLanguageWithoutNotification(this, language, country)
    }

    fun setLanguageWithoutNotification(locale: Locale) {
        localizationDelegate.setLanguageWithoutNotification(this, locale)
    }

    fun getCurrentLanguage(): Locale {
        return localizationDelegate.getLanguage(this)
    }
}
