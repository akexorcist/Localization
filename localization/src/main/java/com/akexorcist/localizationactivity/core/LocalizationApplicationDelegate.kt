package com.akexorcist.localizationactivity.core

import android.content.Context
import android.content.res.Resources
import java.util.*

class LocalizationApplicationDelegate {

    fun onConfigurationChanged(context: Context) = LocalizationUtility.applyLocalizationContext(context)

    fun attachBaseContext(context: Context): Context = LocalizationUtility.applyLocalizationContext(context)

    fun getApplicationContext(applicationContext: Context): Context = LocalizationUtility.applyLocalizationConfig(applicationContext)

    fun getResources(appContext: Context, resources: Resources): Resources = LocalizationUtility.getResources(appContext, resources)

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
