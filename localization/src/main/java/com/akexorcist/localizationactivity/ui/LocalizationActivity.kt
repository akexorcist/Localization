package com.akexorcist.localizationactivity.ui

import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import androidx.annotation.CallSuper
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
        super.attachBaseContext(delegateBaseContext(newBase))
    }

    /**
     * Get a base context for [attachBaseContext]. You can override this function to wrap this
     * context by using ContextWrapper. For example, if your project use ViewPump from
     * `io.github.inflationx:viewpump` module ([ViewPump](https://github.com/InflationX/ViewPump)),
     * you can override this method to wrap this context with `ViewPumpContextWrapper`.
     * ```Kotlin
     * override fun delegateBaseContext(context: Context): Context {
     *  val localizedContext: Context = super.delegateBaseContext(context)
     *  return ViewPumpContextWrapper.wrap(localizedContext)
     * }
     * ```
     * @param context a new base context from [attachBaseContext] parameter.
     * @return a new base context. By default, it will return
     * [LocalizationActivityDelegate.attachBaseContext]
     */
    @CallSuper
    open fun delegateBaseContext(context: Context): Context {
        return localizationDelegate.attachBaseContext(context)
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
