package com.akexorcist.localizationactivity.core

import android.content.Context
import android.content.ContextWrapper
import android.content.res.Resources
import android.os.Build
import android.os.LocaleList
import android.util.DisplayMetrics

/**
 * Created by Akexorcist on 10/19/2017 AD.
 */

class LocalizationContext(base: Context) : ContextWrapper(base) {
    override fun getResources(): Resources {
        val locale = LanguageSetting.getLanguageWithDefault(this, LanguageSetting.getDefaultLanguage(this))
        val configuration = super.getResources().configuration
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            configuration.setLocales(LocaleList(locale))
        } else {
            configuration.setLocale(locale)
        }
        val metrics: DisplayMetrics = super.getResources().displayMetrics
        return Resources(assets, metrics, configuration)
    }
}
