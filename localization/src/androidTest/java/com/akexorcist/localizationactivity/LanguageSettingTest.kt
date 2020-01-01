package com.akexorcist.localizationactivity

import android.content.Context
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.akexorcist.localizationactivity.core.LanguageSetting
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

@RunWith(AndroidJUnit4::class)
class LanguageSettingTest {
    lateinit var appContext: Context

    @Before
    fun setup() {
        appContext = InstrumentationRegistry.getInstrumentation().targetContext
    }

    @Test
    fun getDefaultLanguage_withNoPreference() {
        LanguageSetting.clear(appContext)
        val expectedLocale = Locale.ENGLISH
        val locale = LanguageSetting.getDefaultLanguage(appContext)
        assertEquals(expectedLocale.toString(), locale.toString())
    }

    @Test
    fun getDefaultLanguage_withLanguage() {
        val expectedLocale = Locale.FRANCE
        LanguageSetting.setDefaultLanguage(appContext, expectedLocale)
        val locale = LanguageSetting.getDefaultLanguage(appContext)
        assertEquals(expectedLocale.toString(), locale.toString())
    }

    @Test
    fun getDefaultLanguage_withLanguageAndLocale() {
        val expectedLocale = Locale.FRENCH
        LanguageSetting.setDefaultLanguage(appContext, expectedLocale)
        val locale = LanguageSetting.getDefaultLanguage(appContext)
        assertEquals(expectedLocale.toString(), locale.toString())
    }

    @Test
    fun getCurrentLanguage_withNoPreference() {
        LanguageSetting.clear(appContext)
        val expectedLocale = Locale.ENGLISH
        val locale = LanguageSetting.getLanguage(appContext)
        assertEquals(expectedLocale.toString(), locale.toString())
    }

    @Test
    fun getCurrentLanguage_withLanguage() {
        val expectedLocale = Locale.FRANCE
        LanguageSetting.setLanguage(appContext, expectedLocale)
        val locale = LanguageSetting.getLanguage(appContext)
        assertEquals(expectedLocale.toString(), locale.toString())
    }

    @Test
    fun getCurrentLanguage_withLanguageAndLocale() {
        val expectedLocale = Locale.FRENCH
        LanguageSetting.setLanguage(appContext, expectedLocale)
        val locale = LanguageSetting.getLanguage(appContext)
        assertEquals(expectedLocale.toString(), locale.toString())
    }

    @After
    fun tearDown() {
        LanguageSetting.clear(appContext)
    }
}
