package com.akexorcist.localizationapp

import android.os.Build
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiSelector
import com.agoda.kakao.screen.Screen.Companion.onScreen
import com.akexorcist.localizationapp.annotation.TargetApiLevel
import com.akexorcist.localizationapp.data.ExpectedContent
import com.akexorcist.localizationapp.screen.MainActivityScreen
import com.akexorcist.localizationapp.screen.SimpleFragmentScreen
import org.junit.Ignore
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class DarkThemeTest {
    @JvmField
    val uiDevices: UiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    @Rule
    @JvmField
    val rule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    @Ignore("For local running on Android Q+ only, dark theme in quick settings panel is required")
    fun darkTheme() {
        onScreen<MainActivityScreen> {
            buttonDarkTheme {
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
            }
        }
        uiDevices.openQuickSettings()
        uiDevices.findObject(UiSelector().text("Dark theme")).click()
        uiDevices.pressBack()
        uiDevices.pressBack()
        onScreen<SimpleFragmentScreen> {
            textViewContent {
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
            buttonDarkTheme {
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
            }
        }
        uiDevices.openQuickSettings()
        uiDevices.findObject(UiSelector().text("Dark theme")).click()
        uiDevices.pressBack()
        uiDevices.pressBack()
        onScreen<SimpleFragmentScreen> {
            textViewContent {
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
            buttonDarkTheme {
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
            }
        }
        uiDevices.openQuickSettings()
        uiDevices.findObject(UiSelector().text("Dark theme")).click()
        uiDevices.pressBack()
        uiDevices.pressBack()
        onScreen<SimpleFragmentScreen> {
            textViewContent {
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
            buttonDarkTheme {
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
            }
        }
        uiDevices.openQuickSettings()
        uiDevices.findObject(UiSelector().text("Dark theme")).click()
        uiDevices.pressBack()
        uiDevices.pressBack()
        onScreen<SimpleFragmentScreen> {
            textViewContent {
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
            buttonDarkTheme {
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
            }
        }
        uiDevices.openQuickSettings()
        uiDevices.findObject(UiSelector().text("Dark theme")).click()
        uiDevices.pressBack()
        uiDevices.pressBack()
        onScreen<SimpleFragmentScreen> {
            textViewContent {
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
            buttonDarkTheme {
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
            }
        }
        uiDevices.openQuickSettings()
        uiDevices.findObject(UiSelector().text("Dark theme")).click()
        uiDevices.pressBack()
        uiDevices.pressBack()
        onScreen<SimpleFragmentScreen> {
            textViewContent {
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
            buttonDarkTheme {
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
            }
        }
        uiDevices.openQuickSettings()
        uiDevices.findObject(UiSelector().text("Dark theme")).click()
        uiDevices.pressBack()
        uiDevices.pressBack()
        onScreen<SimpleFragmentScreen> {
            textViewContent {
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
