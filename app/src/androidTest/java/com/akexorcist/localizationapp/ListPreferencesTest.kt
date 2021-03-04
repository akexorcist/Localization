package com.akexorcist.localizationapp

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import com.agoda.kakao.screen.Screen.Companion.onScreen
import com.akexorcist.localizationapp.data.ExpectedContent
import com.akexorcist.localizationapp.screen.MainActivityScreen
import com.akexorcist.localizationapp.screen.ListPreferencesScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class ListPreferencesTest {
    @JvmField
    val uiDevices: UiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    @Rule
    @JvmField
    val rule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun listPreferences() {
        onScreen<MainActivityScreen> {
            buttonListPreferences {
                scrollTo()
                click()
            }
        }
        // Chinese
        onScreen<ListPreferencesScreen> {
            buttonChangeLanguage { click() }
            buttonChinese { click() }
            textViewTitle { hasText(ExpectedContent.HELLO_WORLD_CHINESE) }
            uiDevices.setOrientationRight()
            pressBack()
        }
        onScreen<MainActivityScreen> {
            textViewTitle { hasText(ExpectedContent.HELLO_WORLD_CHINESE) }
            uiDevices.setOrientationNatural()
            textViewTitle { hasText(ExpectedContent.HELLO_WORLD_CHINESE) }
            buttonListPreferences {
                scrollTo()
                click()
            }
        }
        // Italian
        onScreen<ListPreferencesScreen> {
            textViewTitle { hasText(ExpectedContent.HELLO_WORLD_CHINESE) }
            buttonChangeLanguage { click() }
            buttonItalian { click() }
            textViewTitle { hasText(ExpectedContent.HELLO_WORLD_ITALIAN) }
            uiDevices.setOrientationRight()
            pressBack()
        }
        onScreen<MainActivityScreen> {
            textViewTitle { hasText(ExpectedContent.HELLO_WORLD_ITALIAN) }
            uiDevices.setOrientationNatural()
            textViewTitle { hasText(ExpectedContent.HELLO_WORLD_ITALIAN) }
            buttonListPreferences {
                scrollTo()
                click()
            }
        }
        // Japanese
        onScreen<ListPreferencesScreen> {
            textViewTitle { hasText(ExpectedContent.HELLO_WORLD_ITALIAN) }
            buttonChangeLanguage { click() }
            buttonJapanese { click() }
            textViewTitle { hasText(ExpectedContent.HELLO_WORLD_JAPANESE) }
            uiDevices.setOrientationRight()
            pressBack()
        }
        onScreen<MainActivityScreen> {
            textViewTitle { hasText(ExpectedContent.HELLO_WORLD_JAPANESE) }
            uiDevices.setOrientationNatural()
            textViewTitle { hasText(ExpectedContent.HELLO_WORLD_JAPANESE) }
            buttonListPreferences {
                scrollTo()
                click()
            }
        }
        // Korean
        onScreen<ListPreferencesScreen> {
            textViewTitle { hasText(ExpectedContent.HELLO_WORLD_JAPANESE) }
            buttonChangeLanguage { click() }
            buttonKorean { click() }
            textViewTitle { hasText(ExpectedContent.HELLO_WORLD_KOREAN) }
            uiDevices.setOrientationRight()
            pressBack()
        }
        onScreen<MainActivityScreen> {
            textViewTitle { hasText(ExpectedContent.HELLO_WORLD_KOREAN) }
            uiDevices.setOrientationNatural()
            textViewTitle { hasText(ExpectedContent.HELLO_WORLD_KOREAN) }
            buttonListPreferences {
                scrollTo()
                click()
            }
        }
        // Portuguese
        onScreen<ListPreferencesScreen> {
            textViewTitle { hasText(ExpectedContent.HELLO_WORLD_KOREAN) }
            buttonChangeLanguage { click() }
            buttonPortuguese { click() }
            textViewTitle { hasText(ExpectedContent.HELLO_WORLD_PORTUGUESE) }
            uiDevices.setOrientationRight()
            pressBack()
        }
        onScreen<MainActivityScreen> {
            textViewTitle { hasText(ExpectedContent.HELLO_WORLD_PORTUGUESE) }
            uiDevices.setOrientationNatural()
            textViewTitle { hasText(ExpectedContent.HELLO_WORLD_PORTUGUESE) }
            buttonListPreferences {
                scrollTo()
                click()
            }
        }
        // Thai
        onScreen<ListPreferencesScreen> {
            textViewTitle { hasText(ExpectedContent.HELLO_WORLD_PORTUGUESE) }
            buttonChangeLanguage { click() }
            buttonThai { click() }
            textViewTitle { hasText(ExpectedContent.HELLO_WORLD_THAI) }
            uiDevices.setOrientationRight()
            pressBack()
        }
        onScreen<MainActivityScreen> {
            textViewTitle { hasText(ExpectedContent.HELLO_WORLD_THAI) }
            uiDevices.setOrientationNatural()
            textViewTitle { hasText(ExpectedContent.HELLO_WORLD_THAI) }
            buttonListPreferences {
                scrollTo()
                click()
            }
        }
        // American
        onScreen<ListPreferencesScreen> {
            textViewTitle { hasText(ExpectedContent.HELLO_WORLD_THAI) }
            buttonChangeLanguage { click() }
            buttonAmerican { click() }
            textViewTitle { hasText(ExpectedContent.HELLO_WORLD_AMERICAN) }
            uiDevices.setOrientationRight()
            pressBack()
        }
        onScreen<MainActivityScreen> {
            textViewTitle { hasText(ExpectedContent.HELLO_WORLD_AMERICAN) }
            uiDevices.setOrientationNatural()
            textViewTitle { hasText(ExpectedContent.HELLO_WORLD_AMERICAN) }
        }
    }
}
