package com.akexorcist.localizationactivity.core

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.os.LocaleList
import android.util.DisplayMetrics
import java.util.*

object LocalizationUtility {
    fun getLocalizedContext(baseContext: Context): Context {
        val (configuration, isChanged) = getLocalizedConfiguration(baseContext, baseContext.resources.configuration)
        return when {
            isChanged && Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1 ->
                baseContext.createConfigurationContext(configuration)
            isChanged -> {
                @Suppress("DEPRECATION")
                baseContext.resources.updateConfiguration(configuration, baseContext.resources.displayMetrics)
                baseContext
            }
            else -> baseContext
        }
    }

    fun getLocalizedResources(baseContext: Context, baseResources: Resources): Resources {
        val (configuration, isChanged) = getLocalizedConfiguration(baseContext, baseResources.configuration)
        return when {
            isChanged && Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1 ->
                baseContext.createConfigurationContext(configuration).resources
            isChanged -> {
                val metrics: DisplayMetrics = baseContext.resources.displayMetrics
                @Suppress("DEPRECATION")
                return Resources(baseContext.assets, metrics, configuration)
            }
            else -> baseResources
        }
    }

    fun getLocalizedConfiguration(baseContext: Context, baseConfiguration: Configuration): Pair<Configuration, Boolean> {
        val defaultLocale = LanguageSetting.getDefaultLanguage(baseContext)
        val currentLocale = LanguageSetting.getLanguageWithDefault(baseContext, defaultLocale)
        val baseLocale = getLocaleFromConfiguration(baseConfiguration)
        if (!isRequestedLocaleChanged(baseLocale, currentLocale)) return baseConfiguration to false
        return when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.O -> {
                val localeList = LocaleList(currentLocale)
                LocaleList.setDefault(localeList)
                Configuration(baseConfiguration).apply {
                    setLocale(currentLocale)
                    setLocales(localeList)
                } to true
            }
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1 -> {
                Configuration(baseConfiguration).apply {
                    setLocale(currentLocale)
                } to true
            }
            else -> {
                Configuration(baseConfiguration).apply {
                    @Suppress("DEPRECATION")
                    this.locale = currentLocale
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                        setLayoutDirection(currentLocale)
                    }
                } to true
            }
        }
    }

    @Suppress("DEPRECATION")
    private fun getLocaleFromConfiguration(configuration: Configuration): Locale {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            configuration.locales.get(0) ?: Locale.getDefault()
        } else {
            configuration.locale
        }
    }

    private fun isRequestedLocaleChanged(baseLocale: Locale, currentLocale: Locale) =
        !baseLocale.toString().equals(currentLocale.toString(), ignoreCase = true)
}
