package com.akexorcist.localizationapp

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import com.agoda.kakao.screen.Screen.Companion.onScreen
import com.akexorcist.localizationapp.data.ExpectedContent
import com.akexorcist.localizationapp.screen.MainActivityScreen
import com.akexorcist.localizationapp.screen.CustomActivityScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class CustomActivityTest {
    @JvmField
    val uiDevices: UiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    @Rule
    @JvmField
    val rule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun customActivity() {
        onScreen<MainActivityScreen> {
            buttonCustomActivity { click() }
        }
        // Chinese
        onScreen<CustomActivityScreen> {
            buttonChinese {
                scrollTo()
                click()
            }
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
            buttonCustomActivity { click() }
        }
        // Italian
        onScreen<CustomActivityScreen> {
            textViewContent {
                hasText(ExpectedContent.YOUTUBE_CHINESE)
            }
            buttonItalian {
                scrollTo()
                click()
            }
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
            buttonCustomActivity { click() }
        }
        // Japanese
        onScreen<CustomActivityScreen> {
            textViewContent {
                hasText(ExpectedContent.YOUTUBE_ITALIAN)
            }
            buttonJapanese {
                scrollTo()
                click()
            }
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
            buttonCustomActivity { click() }
        }
        // Korean
        onScreen<CustomActivityScreen> {
            textViewContent {
                hasText(ExpectedContent.YOUTUBE_JAPANESE)
            }
            buttonKorean {
                scrollTo()
                click()
            }
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
            buttonCustomActivity { click() }
        }
        // Portuguese
        onScreen<CustomActivityScreen> {
            textViewContent {
                hasText(ExpectedContent.YOUTUBE_KOREAN)
            }
            buttonPortuguese {
                scrollTo()
                click()
            }
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
            buttonCustomActivity { click() }
        }
        // Thai
        onScreen<CustomActivityScreen> {
            textViewContent {
                hasText(ExpectedContent.YOUTUBE_PORTUGUESE)
            }
            buttonThai {
                scrollTo()
                click()
            }
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
            buttonCustomActivity { click() }
        }
        // American
        onScreen<CustomActivityScreen> {
            textViewContent {
                hasText(ExpectedContent.YOUTUBE_THAI)
            }
            buttonAmerican {
                scrollTo()
                click()
            }
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
