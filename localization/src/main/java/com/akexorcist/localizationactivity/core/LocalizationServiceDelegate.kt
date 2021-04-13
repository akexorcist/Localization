package com.akexorcist.localizationactivity.core

import android.app.Service
import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.os.LocaleList
import java.util.*

open class LocalizationServiceDelegate(private val service: Service) {
    fun getResources(resources: Resources): Resources {
        val locale = LanguageSetting.getLanguage(service)
        return when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q -> {
                val localeList = LocaleList(locale)
                LocaleList.setDefault(localeList)
                val config = Configuration().apply {
                    setLocale(locale)
                    setLocales(localeList)
                    setLayoutDirection(locale)
                }
                service.createConfigurationContext(config).resources
            }
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && Build.VERSION.SDK_INT <= Build.VERSION_CODES.P -> {
                val localeList = LocaleList(locale)
                LocaleList.setDefault(localeList)
                resources.configuration.apply {
                    setLocale(locale)
                    setLocales(localeList)
                    setLayoutDirection(locale)
                }
                resources
            }
            else -> {
                val config = Configuration().apply {
                    @Suppress("DEPRECATION")
                    this.locale = locale
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                        setLayoutDirection(locale)
                    }
                }
                @Suppress("DEPRECATION")
                resources.updateConfiguration(config, resources.displayMetrics)
                resources
            }
        }
    }

    fun getLanguage(): Locale {
        return LanguageSetting.getLanguageWithDefault(
            service,
            LanguageSetting.getDefaultLanguage(service)
        )
    }

    fun getApplicationContext(applicationContext: Context): Context {
        return LocalizationUtility.applyLocalizationContext(applicationContext)
    }
}
