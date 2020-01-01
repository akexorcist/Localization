package com.akexorcist.localizationactivity.core

import android.content.Context
import java.util.*

/**
 * Created by Aleksander Mielczarek on 03.04.2016.
 */
class LocalizationApplicationDelegate {

    fun onConfigurationChanged(context: Context) = LocalizationUtility.applyLocalizationContext(context)

    fun attachBaseContext(context: Context): Context = LocalizationUtility.applyLocalizationContext(context)

    fun getApplicationContext(applicationContext: Context): Context = LocalizationUtility.applyLocalizationContext(applicationContext)

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
