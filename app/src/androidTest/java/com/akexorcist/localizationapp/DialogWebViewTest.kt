package com.akexorcist.localizationapp

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import com.agoda.kakao.screen.Screen.Companion.onScreen
import com.akexorcist.localizationapp.data.ExpectedContent
import com.akexorcist.localizationapp.screen.DialogWebViewLanguageChooserScreen
import com.akexorcist.localizationapp.screen.DialogWebViewMainScreen
import com.akexorcist.localizationapp.screen.DialogWebViewSiteScreen
import com.akexorcist.localizationapp.screen.MainActivityScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.web.webdriver.Locator
import org.junit.Ignore

@RunWith(AndroidJUnit4ClassRunner::class)
class DialogWebViewTest {
    @JvmField
    val uiDevices: UiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    @Rule
    @JvmField
    val rule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    @Ignore("For local running only. There's an issue with WebView when disabled animation in UI test")
    fun dialogAndWebView() {
        onScreen<MainActivityScreen> {
            buttonDialogWebView {
                scrollTo()
                click()
            }
        }
        Thread.sleep(1000L)
        onScreen<DialogWebViewMainScreen> {
            buttonShowWebsite { click() }
        }
        onScreen<DialogWebViewSiteScreen> {
            buttonBack { click() }
        }
        // American
        onScreen<DialogWebViewMainScreen> {
            buttonChangeLanguage { click() }
        }
        onScreen<DialogWebViewLanguageChooserScreen> {
            buttonAmerican { click() }
        }
        onScreen<DialogWebViewMainScreen> {
            buttonShowWebsite { click() }
        }
        onScreen<DialogWebViewSiteScreen> {
            webViewContent {
                withElement(Locator.ID, "content") {
                    hasText(ExpectedContent.HELLO_WORLD_AMERICAN)
                }
            }
            buttonBack { click() }
        }
        onScreen<DialogWebViewMainScreen> {
            buttonBack { click() }
        }
        onScreen<MainActivityScreen> {
            textViewTitle {
                hasText(ExpectedContent.HELLO_WORLD_AMERICAN)
            }
        }
    }
}
