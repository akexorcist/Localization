package com.akexorcist.localizationactivity.core

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.os.Build
import android.os.Handler
import android.os.LocaleList
import com.akexorcist.localizationactivity.ui.BlankDummyActivity
import java.util.*

open class LocalizationActivityDelegate(val activity: Activity) {
    private var isLocalizationChanged = false
    private lateinit var currentLanguage: Locale
    private val localeChangedListeners = ArrayList<OnLocaleChangedListener>()

    companion object {
        private const val KEY_ACTIVITY_LOCALE_CHANGED = "activity_locale_changed"
    }

    fun addOnLocaleChangedListener(onLocaleChangedListener: OnLocaleChangedListener) {
        localeChangedListeners.add(onLocaleChangedListener)
    }

    fun removeOnLocaleChangedListener(onLocaleChangedListener: OnLocaleChangedListener) {
        localeChangedListeners.remove(onLocaleChangedListener)
    }

    fun onCreate() {
        currentLanguage = LanguageSetting.getDefaultLanguage(activity)
        setupLanguage()
        checkBeforeLocaleChanging()
    }

    // If activity is run to back stack. So we have to check if this activity is resume working.
    fun onResume(context: Context) {
        Handler().post {
            checkLocaleChange(context)
            checkAfterLocaleChanging()
        }
    }

    fun attachBaseContext(context: Context): Context {
        val locale = LanguageSetting.getLanguage(context)
        val config = context.resources.configuration
        return when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.N -> {
                config.setLocale(locale)
                val localeList = LocaleList(locale)
                LocaleList.setDefault(localeList)
                config.setLocales(localeList)
                context.createConfigurationContext(config)
            }
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1 -> {
                config.setLocale(locale)
                context.createConfigurationContext(config)
            }
            else -> context
        }
    }

    fun getApplicationContext(applicationContext: Context): Context {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            applicationContext
        } else {
            LocalizationUtility.applyLocalizationContext(applicationContext)
        }
    }

    @Suppress("DEPRECATION")
    fun getResources(resources: Resources): Resources {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            val locale = LanguageSetting.getLanguage(activity)
            val config = resources.configuration
            config.setLocale(locale)
            val localeList = LocaleList(locale)
            LocaleList.setDefault(localeList)
            config.setLocales(localeList)
            resources
        } else {
            val config = resources.configuration
            config.locale = LanguageSetting.getLanguage(activity)
            val metrics = resources.displayMetrics
            Resources(activity.assets, metrics, config)
        }
    }

    // Provide method to set application language by country name.
    fun setLanguage(context: Context, newLanguage: String) {
        val locale = Locale(newLanguage)
        setLanguage(context, locale)
    }

    fun setLanguage(context: Context, newLanguage: String, newCountry: String) {
        val locale = Locale(newLanguage, newCountry)
        setLanguage(context, locale)
    }

    fun setLanguage(context: Context, newLocale: Locale) {
        if (!isCurrentLanguageSetting(context, newLocale)) {
            LanguageSetting.setLanguage(activity, newLocale)
            notifyLanguageChanged()
        }
    }

    fun setDefaultLanguage(language: String) {
        val locale = Locale(language)
        setDefaultLanguage(locale)
    }

    fun setDefaultLanguage(language: String, country: String) {
        val locale = Locale(language, country)
        setDefaultLanguage(locale)
    }

    fun setDefaultLanguage(locale: Locale) {
        LanguageSetting.setDefaultLanguage(activity, locale)
    }

    // Get current language
    fun getLanguage(context: Context): Locale {
        return LanguageSetting.getLanguage(context)
    }

    // Check that bundle come from locale change.
    // If yes, bundle will be remove and set boolean flag to "true".
    private fun checkBeforeLocaleChanging() {
        val isLocalizationChanged = activity.intent.getBooleanExtra(KEY_ACTIVITY_LOCALE_CHANGED, false)
        if (isLocalizationChanged) {
            this.isLocalizationChanged = true
            activity.intent.removeExtra(KEY_ACTIVITY_LOCALE_CHANGED)
        }
    }

    // Setup language to locale and language preference.
    // This method will called before onCreate.
    private fun setupLanguage() {
        val locale = LanguageSetting.getLanguage(activity)
        setupLocale(locale)
        currentLanguage = locale
        LanguageSetting.setLanguage(activity, locale)
    }

    // Set locale configuration.
    private fun setupLocale(locale: Locale) {
        updateLocaleConfiguration(activity, locale)
    }


    private fun updateLocaleConfiguration(context: Context, locale: Locale) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
            val config = context.resources.configuration
            config.locale = locale
            val dm = context.resources.displayMetrics
            context.resources.updateConfiguration(config, dm)
        }
    }

    // Avoid duplicated setup
    private fun isCurrentLanguageSetting(context: Context, newLocale: Locale): Boolean {
        val oldLocale = LanguageSetting.getLanguage(context).toString()
        return newLocale.toString() == oldLocale
    }

    // Let's take it change! (Using recreate method that available on API 11 or more.
    private fun notifyLanguageChanged() {
        sendOnBeforeLocaleChangedEvent()
        activity.intent.putExtra(KEY_ACTIVITY_LOCALE_CHANGED, true)
        callDummyActivity()
        activity.recreate()
    }

    // Check if locale has change while this activity was run to back stack.
    private fun checkLocaleChange(context: Context) {
        if (!isCurrentLanguageSetting(context, currentLanguage)) {
            sendOnBeforeLocaleChangedEvent()
            isLocalizationChanged = true
            callDummyActivity()
            activity.recreate()
        }
    }

    // Call override method if local is really changed
    private fun checkAfterLocaleChanging() {
        if (isLocalizationChanged) {
            sendOnAfterLocaleChangedEvent()
            isLocalizationChanged = false
        }
    }

    private fun sendOnBeforeLocaleChangedEvent() {
        for (changedListener in localeChangedListeners) {
            changedListener.onBeforeLocaleChanged()
        }
    }

    private fun sendOnAfterLocaleChangedEvent() {
        for (listener in localeChangedListeners) {
            listener.onAfterLocaleChanged()
        }
    }

    private fun callDummyActivity() {
        activity.startActivity(Intent(activity, BlankDummyActivity::class.java))
    }
}