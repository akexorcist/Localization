package com.akexorcist.localizationapp

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import com.agoda.kakao.screen.Screen.Companion.onScreen
import com.akexorcist.localizationapp.data.ExpectedContent
import com.akexorcist.localizationapp.screen.MainActivityScreen
import com.akexorcist.localizationapp.screen.StackedHomeScreen
import com.akexorcist.localizationapp.screen.StackedLanguageChooserScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class StackedActivityTest {
    @JvmField
    val uiDevices: UiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    @Rule
    @JvmField
    val rule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun stackedActivity() {
        onScreen<MainActivityScreen> {
            buttonStackedActivity {
                scrollTo()
                click()
            }
        }
        // Chinese
        onScreen<StackedHomeScreen> {
            buttonChangeLanguage { click() }
        }
        onScreen<StackedLanguageChooserScreen> {
            buttonChinese { click() }
        }
        onScreen<StackedHomeScreen> {
            textViewContent {
                hasText(ExpectedContent.YOUTUBE_CHINESE)
                uiDevices.setOrientationRight()
                hasText(ExpectedContent.YOUTUBE_CHINESE)
            }
            pressBack()
        }
        onScreen<MainActivityScreen> {
            textViewTitle {
                hasText(ExpectedContent.HELLO_WORLD_CHINESE)
                uiDevices.setOrientationNatural()
                hasText(ExpectedContent.HELLO_WORLD_CHINESE)
            }
            buttonStackedActivity {
                scrollTo()
                click()
            }
        }
        // Italian
        onScreen<StackedHomeScreen> {
            textViewContent {
                hasText(ExpectedContent.YOUTUBE_CHINESE)
            }
            buttonChangeLanguage { click() }
        }
        onScreen<StackedLanguageChooserScreen> {
            buttonItalian { click() }
        }
        onScreen<StackedHomeScreen> {
            textViewContent {
                hasText(ExpectedContent.YOUTUBE_ITALIAN)
                uiDevices.setOrientationRight()
                hasText(ExpectedContent.YOUTUBE_ITALIAN)
            }
            pressBack()
        }
        onScreen<MainActivityScreen> {
            textViewTitle {
                hasText(ExpectedContent.HELLO_WORLD_ITALIAN)
                uiDevices.setOrientationNatural()
                hasText(ExpectedContent.HELLO_WORLD_ITALIAN)
            }
            buttonStackedActivity {
                scrollTo()
                click()
            }
        }
        // Japanese
        onScreen<StackedHomeScreen> {
            textViewContent {
                hasText(ExpectedContent.YOUTUBE_ITALIAN)
            }
            buttonChangeLanguage { click() }
        }
        onScreen<StackedLanguageChooserScreen> {
            buttonJapanese { click() }
        }
        onScreen<StackedHomeScreen> {
            textViewContent {
                hasText(ExpectedContent.YOUTUBE_JAPANESE)
                uiDevices.setOrientationRight()
                hasText(ExpectedContent.YOUTUBE_JAPANESE)
            }
            pressBack()
        }
        onScreen<MainActivityScreen> {
            textViewTitle {
                hasText(ExpectedContent.HELLO_WORLD_JAPANESE)
                uiDevices.setOrientationNatural()
                hasText(ExpectedContent.HELLO_WORLD_JAPANESE)
            }
            buttonStackedActivity {
                scrollTo()
                click()
            }
        }
        // Korean
        onScreen<StackedHomeScreen> {
            textViewContent {
                hasText(ExpectedContent.YOUTUBE_JAPANESE)
            }
            buttonChangeLanguage { click() }
        }
        onScreen<StackedLanguageChooserScreen> {
            buttonKorean { click() }
        }
        onScreen<StackedHomeScreen> {
            textViewContent {
                hasText(ExpectedContent.YOUTUBE_KOREAN)
                uiDevices.setOrientationRight()
                hasText(ExpectedContent.YOUTUBE_KOREAN)
            }
            pressBack()
        }
        onScreen<MainActivityScreen> {
            textViewTitle {
                hasText(ExpectedContent.HELLO_WORLD_KOREAN)
                uiDevices.setOrientationNatural()
                hasText(ExpectedContent.HELLO_WORLD_KOREAN)
            }
            buttonStackedActivity {
                scrollTo()
                click()
            }
        }
        // Portuguese
        onScreen<StackedHomeScreen> {
            textViewContent {
                hasText(ExpectedContent.YOUTUBE_KOREAN)
            }
            buttonChangeLanguage { click() }
        }
        onScreen<StackedLanguageChooserScreen> {
            buttonPortuguese { click() }
        }
        onScreen<StackedHomeScreen> {
            textViewContent {
                hasText(ExpectedContent.YOUTUBE_PORTUGUESE)
                uiDevices.setOrientationRight()
                hasText(ExpectedContent.YOUTUBE_PORTUGUESE)
            }
            pressBack()
        }
        onScreen<MainActivityScreen> {
            textViewTitle {
                hasText(ExpectedContent.HELLO_WORLD_PORTUGUESE)
                uiDevices.setOrientationNatural()
                hasText(ExpectedContent.HELLO_WORLD_PORTUGUESE)
            }
            buttonStackedActivity {
                scrollTo()
                click()
            }
        }
        // Thai
        onScreen<StackedHomeScreen> {
            textViewContent {
                hasText(ExpectedContent.YOUTUBE_PORTUGUESE)
            }
            buttonChangeLanguage { click() }
        }
        onScreen<StackedLanguageChooserScreen> {
            buttonThai { click() }
        }
        onScreen<StackedHomeScreen> {
            textViewContent {
                hasText(ExpectedContent.YOUTUBE_THAI)
                uiDevices.setOrientationRight()
                hasText(ExpectedContent.YOUTUBE_THAI)
            }
            pressBack()
        }
        onScreen<MainActivityScreen> {
            textViewTitle {
                hasText(ExpectedContent.HELLO_WORLD_THAI)
                uiDevices.setOrientationNatural()
                hasText(ExpectedContent.HELLO_WORLD_THAI)
            }
            buttonStackedActivity {
                scrollTo()
                click()
            }
        }
        // American
        onScreen<StackedHomeScreen> {
            textViewContent {
                hasText(ExpectedContent.YOUTUBE_THAI)
            }
            buttonChangeLanguage { click() }
        }
        onScreen<StackedLanguageChooserScreen> {
            buttonAmerican { click() }
        }
        onScreen<StackedHomeScreen> {
            textViewContent {
                hasText(ExpectedContent.YOUTUBE_AMERICAN)
                uiDevices.setOrientationRight()
                hasText(ExpectedContent.YOUTUBE_AMERICAN)
            }
            pressBack()
        }
        onScreen<MainActivityScreen> {
            textViewTitle {
                hasText(ExpectedContent.HELLO_WORLD_AMERICAN)
                uiDevices.setOrientationNatural()
                hasText(ExpectedContent.HELLO_WORLD_AMERICAN)
            }
        }
    }
}
