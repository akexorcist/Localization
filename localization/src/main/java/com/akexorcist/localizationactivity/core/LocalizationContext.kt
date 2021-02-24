package com.akexorcist.localizationactivity.core

import android.content.Context
import android.content.ContextWrapper
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.os.LocaleList
import android.util.DisplayMetrics

class LocalizationContext(base: Context) : ContextWrapper(base) {
    override fun getResources(): Resources {
        val locale = LanguageSetting.getLanguageWithDefault(this, LanguageSetting.getDefaultLanguage(this))

        return when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.O -> {
                val configuration = Configuration().apply {
                    setLocales(LocaleList(locale))
                }
                createConfigurationContext(configuration).resources
            }
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1 -> {
                val configuration = Configuration().apply {
                    setLocale(locale)
                }
                createConfigurationContext(configuration).resources
            }
            else -> {
                val configuration = Configuration().apply {
                    @Suppress("DEPRECATION")
                    this.locale = locale
                }
                val metrics: DisplayMetrics = super.getResources().displayMetrics
                @Suppress("DEPRECATION")
                return Resources(assets, metrics, configuration)
            }
        }
    }
}
