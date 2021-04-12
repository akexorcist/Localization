package com.akexorcist.localizationapp

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import com.agoda.kakao.screen.Screen.Companion.onScreen
import com.akexorcist.localizationapp.data.ExpectedContent
import com.akexorcist.localizationapp.screen.MainActivityScreen
import com.akexorcist.localizationapp.screen.SimpleFragmentScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class SimpleFragmentTest {
    @JvmField
    val uiDevices: UiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    @Rule
    @JvmField
    val rule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun simpleFragment() {
        onScreen<MainActivityScreen> {
            buttonSimpleFragment {
                scrollTo()
                click()
            }
        }
        // Chinese
        onScreen<SimpleFragmentScreen> {
            buttonChinese {
                scrollTo()
                click()
            }
            textViewContent {
                hasText(ExpectedContent.APPLE_CHINESE)
                uiDevices.setOrientationRight()
                hasText(ExpectedContent.APPLE_CHINESE)
            }
            pressBack()
        }
        onScreen<MainActivityScreen> {
            textViewTitle {
                hasText(ExpectedContent.HELLO_WORLD_CHINESE)
                uiDevices.setOrientationNatural()
                hasText(ExpectedContent.HELLO_WORLD_CHINESE)
            }
            buttonSimpleFragment {
                scrollTo()
                click()
            }
        }
        // Italian
        onScreen<SimpleFragmentScreen> {
            textViewContent {
                hasText(ExpectedContent.APPLE_CHINESE)
            }
            buttonItalian {
                scrollTo()
                click()
            }
            textViewContent {
                hasText(ExpectedContent.APPLE_ITALIAN)
                uiDevices.setOrientationRight()
                hasText(ExpectedContent.APPLE_ITALIAN)
            }
            pressBack()
        }
        onScreen<MainActivityScreen> {
            textViewTitle {
                hasText(ExpectedContent.HELLO_WORLD_ITALIAN)
                uiDevices.setOrientationNatural()
                hasText(ExpectedContent.HELLO_WORLD_ITALIAN)
            }
            buttonSimpleFragment {
                scrollTo()
                click()
            }
        }
        // Japanese
        onScreen<SimpleFragmentScreen> {
            textViewContent {
                hasText(ExpectedContent.APPLE_ITALIAN)
            }
            buttonJapanese {
                scrollTo()
                click()
            }
            textViewContent {
                hasText(ExpectedContent.APPLE_JAPANESE)
                uiDevices.setOrientationRight()
                hasText(ExpectedContent.APPLE_JAPANESE)
            }
            pressBack()
        }
        onScreen<MainActivityScreen> {
            textViewTitle {
                hasText(ExpectedContent.HELLO_WORLD_JAPANESE)
                uiDevices.setOrientationNatural()
                hasText(ExpectedContent.HELLO_WORLD_JAPANESE)
            }
            buttonSimpleFragment {
                scrollTo()
                click()
            }
        }
        // Korean
        onScreen<SimpleFragmentScreen> {
            textViewContent {
                hasText(ExpectedContent.APPLE_JAPANESE)
            }
            buttonKorean {
                scrollTo()
                click()
            }
            textViewContent {
                hasText(ExpectedContent.APPLE_KOREAN)
                uiDevices.setOrientationRight()
                hasText(ExpectedContent.APPLE_KOREAN)
            }
            pressBack()
        }
        onScreen<MainActivityScreen> {
            textViewTitle {
                hasText(ExpectedContent.HELLO_WORLD_KOREAN)
                uiDevices.setOrientationNatural()
                hasText(ExpectedContent.HELLO_WORLD_KOREAN)
            }
            buttonSimpleFragment {
                scrollTo()
                click()
            }
        }
        // Portuguese
        onScreen<SimpleFragmentScreen> {
            textViewContent {
                hasText(ExpectedContent.APPLE_KOREAN)
            }
            buttonPortuguese {
                scrollTo()
                click()
            }
            textViewContent {
                hasText(ExpectedContent.APPLE_PORTUGUESE)
                uiDevices.setOrientationRight()
                hasText(ExpectedContent.APPLE_PORTUGUESE)
            }
            pressBack()
        }
        onScreen<MainActivityScreen> {
            textViewTitle {
                hasText(ExpectedContent.HELLO_WORLD_PORTUGUESE)
                uiDevices.setOrientationNatural()
                hasText(ExpectedContent.HELLO_WORLD_PORTUGUESE)
            }
            buttonSimpleFragment {
                scrollTo()
                click()
            }
        }
        // Thai
        onScreen<SimpleFragmentScreen> {
            textViewContent {
                hasText(ExpectedContent.APPLE_PORTUGUESE)
            }
            buttonThai {
                scrollTo()
                click()
            }
            textViewContent {
                hasText(ExpectedContent.APPLE_THAI)
                uiDevices.setOrientationRight()
                hasText(ExpectedContent.APPLE_THAI)
            }
            pressBack()
        }
        onScreen<MainActivityScreen> {
            textViewTitle {
                hasText(ExpectedContent.HELLO_WORLD_THAI)
                uiDevices.setOrientationNatural()
                hasText(ExpectedContent.HELLO_WORLD_THAI)
            }
            buttonSimpleFragment {
                scrollTo()
                click()
            }
        }
        // American
        onScreen<SimpleFragmentScreen> {
            textViewContent {
                hasText(ExpectedContent.APPLE_THAI)
            }
            buttonAmerican {
                scrollTo()
                click()
            }
            textViewContent {
                hasText(ExpectedContent.APPLE_AMERICAN)
                uiDevices.setOrientationRight()
                hasText(ExpectedContent.APPLE_AMERICAN)
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
