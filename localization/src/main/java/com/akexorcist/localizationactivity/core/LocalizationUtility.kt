package com.akexorcist.localizationactivity.core

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.os.LocaleList
import android.util.DisplayMetrics
import java.util.*

object LocalizationUtility {
    fun applyLocalizationConfig(baseContext: Context): Context {
        val baseLocale = getLocaleFromConfiguration(baseContext.resources.configuration)
        val currentLocale = LanguageSetting.getLanguageWithDefault(
                baseContext,
                LanguageSetting.getDefaultLanguage(baseContext)
        )
        if (!isRequestedLocaleChanged(baseLocale, currentLocale)) return baseContext

        return when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.O -> {
                val localeList = LocaleList(currentLocale)
                LocaleList.setDefault(localeList)
                val config = Configuration().apply {
                    setLocale(currentLocale)
                    setLocales(localeList)
                }
                baseContext.createConfigurationContext(config)
            }
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1 -> {
                val config = Configuration().apply {
                    setLocale(currentLocale)
                }
                baseContext.createConfigurationContext(config)
            }
            else -> {
                val config = Configuration().apply {
                    @Suppress("DEPRECATION")
                    locale = currentLocale
                }
                @Suppress("DEPRECATION")
                baseContext.resources.updateConfiguration(
                        config,
                        baseContext.resources.displayMetrics
                )
                baseContext
            }
        }
    }

    fun applyLocalizationContext(baseContext: Context): Context {
        val baseLocale = getLocaleFromConfiguration(baseContext.resources.configuration)
        val currentLocale = LanguageSetting.getLanguageWithDefault(
                baseContext,
                LanguageSetting.getDefaultLanguage(baseContext)
        )
        if (!isRequestedLocaleChanged(baseLocale, currentLocale)) return baseContext

        return when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.O -> {
                val context = LocalizationContext(baseContext)
                val localeList = LocaleList(currentLocale)
                LocaleList.setDefault(localeList)
                val config = Configuration().apply {
                    setLocale(currentLocale)
                    setLocales(localeList)
                }
                context.createConfigurationContext(config)
            }
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1 -> {
                val context = LocalizationContext(baseContext)
                val config = Configuration().apply {
                    setLocale(currentLocale)
                }
                context.createConfigurationContext(config)
            }
            else -> {
                val config = Configuration().apply {
                    @Suppress("DEPRECATION")
                    locale = currentLocale
                }
                @Suppress("DEPRECATION")
                baseContext.resources.updateConfiguration(
                        config,
                        baseContext.resources.displayMetrics
                )
                baseContext
            }
        }
    }

    private fun isRequestedLocaleChanged(baseLocale: Locale, currentLocale: Locale) =
            !baseLocale.toString().equals(currentLocale.toString(), ignoreCase = true)

    fun getResources(appContext: Context): Resources {
        val locale = LanguageSetting.getLanguageWithDefault(appContext, LanguageSetting.getDefaultLanguage(appContext))

        return when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.O -> {
                val configuration = Configuration().apply {
                    setLocales(LocaleList(locale))
                }
                appContext.createConfigurationContext(configuration).resources
            }
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1 -> {
                val configuration = Configuration().apply {
                    setLocale(locale)
                }
                appContext.createConfigurationContext(configuration).resources
            }
            else -> {
                val configuration = Configuration().apply {
                    @Suppress("DEPRECATION")
                    this.locale = locale
                }
                val metrics: DisplayMetrics = appContext.resources.displayMetrics
                @Suppress("DEPRECATION")
                return Resources(appContext.assets, metrics, configuration)
            }
        }
    }

    @Suppress("DEPRECATION")
    fun getLocaleFromConfiguration(configuration: Configuration): Locale {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            configuration.locales.get(0)
        } else {
            configuration.locale
        }
    }
}
