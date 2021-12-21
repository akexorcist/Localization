package com.akexorcist.localizationactivity.core

import android.content.Context
import android.content.res.Resources
import android.webkit.WebView
import java.util.*

class LocalizationApplicationDelegate {
    fun onCreate(context: Context) {
        WebView(context).destroy()
    }

    fun onConfigurationChanged(context: Context) = LocalizationUtility.getLocalizedContext(context)

    fun attachBaseContext(context: Context): Context = LocalizationUtility.getLocalizedContext(context)

    fun getApplicationContext(applicationContext: Context): Context = LocalizationUtility.getLocalizedContext(applicationContext)

    fun getResources(appContext: Context, resources: Resources): Resources = LocalizationUtility.getLocalizedResources(appContext, resources)

    fun setDefaultLanguage(context: Context, language: String) {
        val locale = Locale(language)
        setDefaultLanguage(context, locale)
    }

    fun setDefaultLanguage(context: Context, language: String, country: String) {
        val locale = Locale(language, country)
        setDefaultLanguage(context, locale)
    }

    fun setDefaultLanguage(context: Context, locale: Locale) {
        LanguageSetting.setDefaultLanguage(context, locale)
    }
}
