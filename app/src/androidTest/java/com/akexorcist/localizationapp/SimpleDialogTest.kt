package com.akexorcist.localizationapp

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import com.agoda.kakao.screen.Screen.Companion.onScreen
import com.akexorcist.localizationapp.data.ExpectedContent
import com.akexorcist.localizationapp.screen.MainActivityScreen
import com.akexorcist.localizationapp.screen.SimpleDialogContentScreen
import com.akexorcist.localizationapp.screen.SimpleDialogLanguageChooserScreen
import com.akexorcist.localizationapp.screen.SimpleDialogMainScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class SimpleDialogTest {
    @JvmField
    val uiDevices: UiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    @Rule
    @JvmField
    val rule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun simpleDialog() {
        onScreen<MainActivityScreen> {
            buttonSimpleDialog {
                scrollTo()
                click()
            }
        }
        // Chinese
        onScreen<SimpleDialogMainScreen> {
            buttonChangeLanguage { click() }
        }
        onScreen<SimpleDialogLanguageChooserScreen> {
            buttonChinese { click() }
        }
        onScreen<SimpleDialogMainScreen> {
            buttonShowContent { click() }
        }
        onScreen<SimpleDialogContentScreen> {
            textViewContent {
                hasText(ExpectedContent.YOUTUBE_CHINESE)
                uiDevices.setOrientationRight()
                hasText(ExpectedContent.YOUTUBE_CHINESE)
            }
            pressBack()
            uiDevices.setOrientationNatural()
        }
        // Italian
        onScreen<SimpleDialogMainScreen> {
            buttonChangeLanguage { click() }
        }
        onScreen<SimpleDialogLanguageChooserScreen> {
            buttonItalian { click() }
        }
        onScreen<SimpleDialogMainScreen> {
            buttonShowContent { click() }
        }
        onScreen<SimpleDialogContentScreen> {
            textViewContent {
                hasText(ExpectedContent.YOUTUBE_ITALIAN)
                uiDevices.setOrientationRight()
                hasText(ExpectedContent.YOUTUBE_ITALIAN)
            }
            pressBack()
            uiDevices.setOrientationNatural()
        }
        // Japanese
        onScreen<SimpleDialogMainScreen> {
            buttonChangeLanguage { click() }
        }
        onScreen<SimpleDialogLanguageChooserScreen> {
            buttonJapanese { click() }
        }
        onScreen<SimpleDialogMainScreen> {
            buttonShowContent { click() }
        }
        onScreen<SimpleDialogContentScreen> {
            textViewContent {
                hasText(ExpectedContent.YOUTUBE_JAPANESE)
                uiDevices.setOrientationRight()
                hasText(ExpectedContent.YOUTUBE_JAPANESE)
            }
            pressBack()
            uiDevices.setOrientationNatural()
        }
        // Korean
        onScreen<SimpleDialogMainScreen> {
            buttonChangeLanguage { click() }
        }
        onScreen<SimpleDialogLanguageChooserScreen> {
            buttonKorean { click() }
        }
        onScreen<SimpleDialogMainScreen> {
            buttonShowContent { click() }
        }
        onScreen<SimpleDialogContentScreen> {
            textViewContent {
                hasText(ExpectedContent.YOUTUBE_KOREAN)
                uiDevices.setOrientationRight()
                hasText(ExpectedContent.YOUTUBE_KOREAN)
            }
            pressBack()
            uiDevices.setOrientationNatural()
        }
        // Portuguese
        onScreen<SimpleDialogMainScreen> {
            buttonChangeLanguage { click() }
        }
        onScreen<SimpleDialogLanguageChooserScreen> {
            buttonPortuguese { click() }
        }
        onScreen<SimpleDialogMainScreen> {
            buttonShowContent { click() }
        }
        onScreen<SimpleDialogContentScreen> {
            textViewContent {
                hasText(ExpectedContent.YOUTUBE_PORTUGUESE)
                uiDevices.setOrientationRight()
                hasText(ExpectedContent.YOUTUBE_PORTUGUESE)
            }
            pressBack()
            uiDevices.setOrientationNatural()
        }
        // Thai
        onScreen<SimpleDialogMainScreen> {
            buttonChangeLanguage { click() }
        }
        onScreen<SimpleDialogLanguageChooserScreen> {
            buttonThai { click() }
        }
        onScreen<SimpleDialogMainScreen> {
            buttonShowContent { click() }
        }
        onScreen<SimpleDialogContentScreen> {
            textViewContent {
                hasText(ExpectedContent.YOUTUBE_THAI)
                uiDevices.setOrientationRight()
                hasText(ExpectedContent.YOUTUBE_THAI)
            }
            pressBack()
            uiDevices.setOrientationNatural()
        }
        // American
        onScreen<SimpleDialogMainScreen> {
            buttonChangeLanguage { click() }
        }
        onScreen<SimpleDialogLanguageChooserScreen> {
            buttonAmerican { click() }
        }
        onScreen<SimpleDialogMainScreen> {
            buttonShowContent { click() }
        }
        onScreen<SimpleDialogContentScreen> {
            textViewContent {
                hasText(ExpectedContent.YOUTUBE_AMERICAN)
                uiDevices.setOrientationRight()
                hasText(ExpectedContent.YOUTUBE_AMERICAN)
            }
            pressBack()
            uiDevices.setOrientationNatural()
        }
        // End
        onScreen<SimpleDialogMainScreen> {
            buttonBack { click() }
        }
        onScreen<MainActivityScreen> {
            textViewTitle {
                hasText(ExpectedContent.HELLO_WORLD_AMERICAN)
            }
        }
    }
}
