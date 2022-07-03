package com.akexorcist.localizationapp

import androidx.test.espresso.web.webdriver.Locator
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

@RunWith(AndroidJUnit4ClassRunner::class)
class DialogWebViewTest {
    @JvmField
    val uiDevices: UiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    @Rule
    @JvmField
    val rule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun dialogAndWebView() {
        // Chinese
        onScreen<MainActivityScreen> {
            buttonDialogWebView {
                scrollTo()
                click()
            }
        }
        onScreen<DialogWebViewMainScreen> {
            buttonChangeLanguage { click() }
        }
        onScreen<DialogWebViewLanguageChooserScreen> {
            buttonChinese { click() }
        }
        onScreen<DialogWebViewMainScreen> {
            buttonShowWebsite { click() }
        }
        onScreen<DialogWebViewSiteScreen> {
            webViewContent {
                withElement(Locator.ID, "content") {
                    hasText(ExpectedContent.HELLO_WORLD_CHINESE)
                }
            }
            buttonBack { click() }
        }
        onScreen<DialogWebViewMainScreen> {
            buttonBack { click() }
        }
        onScreen<MainActivityScreen> {
            textViewTitle {
                hasText(ExpectedContent.HELLO_WORLD_CHINESE)
            }
        }
        // Italian
        onScreen<MainActivityScreen> {
            buttonDialogWebView {
                scrollTo()
                click()
            }
        }
        onScreen<DialogWebViewMainScreen> {
            buttonChangeLanguage { click() }
        }
        onScreen<DialogWebViewLanguageChooserScreen> {
            buttonItalian { click() }
        }
        onScreen<DialogWebViewMainScreen> {
            buttonShowWebsite { click() }
        }
        onScreen<DialogWebViewSiteScreen> {
            webViewContent {
                withElement(Locator.ID, "content") {
                    hasText(ExpectedContent.HELLO_WORLD_ITALIAN)
                }
            }
            buttonBack { click() }
        }
        onScreen<DialogWebViewMainScreen> {
            buttonBack { click() }
        }
        onScreen<MainActivityScreen> {
            textViewTitle {
                hasText(ExpectedContent.HELLO_WORLD_ITALIAN)
            }
        }
        // Japanese
        onScreen<MainActivityScreen> {
            buttonDialogWebView {
                scrollTo()
                click()
            }
        }
        onScreen<DialogWebViewMainScreen> {
            buttonChangeLanguage { click() }
        }
        onScreen<DialogWebViewLanguageChooserScreen> {
            buttonJapanese { click() }
        }
        onScreen<DialogWebViewMainScreen> {
            buttonShowWebsite { click() }
        }
        onScreen<DialogWebViewSiteScreen> {
            webViewContent {
                withElement(Locator.ID, "content") {
                    hasText(ExpectedContent.HELLO_WORLD_JAPANESE)
                }
            }
            buttonBack { click() }
        }
        onScreen<DialogWebViewMainScreen> {
            buttonBack { click() }
        }
        onScreen<MainActivityScreen> {
            textViewTitle {
                hasText(ExpectedContent.HELLO_WORLD_JAPANESE)
            }
        }
        // Korean
        onScreen<MainActivityScreen> {
            buttonDialogWebView {
                scrollTo()
                click()
            }
        }
        onScreen<DialogWebViewMainScreen> {
            buttonChangeLanguage { click() }
        }
        onScreen<DialogWebViewLanguageChooserScreen> {
            buttonKorean { click() }
        }
        onScreen<DialogWebViewMainScreen> {
            buttonShowWebsite { click() }
        }
        onScreen<DialogWebViewSiteScreen> {
            webViewContent {
                withElement(Locator.ID, "content") {
                    hasText(ExpectedContent.HELLO_WORLD_KOREAN)
                }
            }
            buttonBack { click() }
        }
        onScreen<DialogWebViewMainScreen> {
            buttonBack { click() }
        }
        onScreen<MainActivityScreen> {
            textViewTitle {
                hasText(ExpectedContent.HELLO_WORLD_KOREAN)
            }
        }
        // Korean
        onScreen<MainActivityScreen> {
            buttonDialogWebView {
                scrollTo()
                click()
            }
        }
        onScreen<DialogWebViewMainScreen> {
            buttonChangeLanguage { click() }
        }
        onScreen<DialogWebViewLanguageChooserScreen> {
            buttonPortuguese { click() }
        }
        onScreen<DialogWebViewMainScreen> {
            buttonShowWebsite { click() }
        }
        onScreen<DialogWebViewSiteScreen> {
            webViewContent {
                withElement(Locator.ID, "content") {
                    hasText(ExpectedContent.HELLO_WORLD_PORTUGUESE)
                }
            }
            buttonBack { click() }
        }
        onScreen<DialogWebViewMainScreen> {
            buttonBack { click() }
        }
        onScreen<MainActivityScreen> {
            textViewTitle {
                hasText(ExpectedContent.HELLO_WORLD_PORTUGUESE)
            }
        }
        // Thai
        onScreen<MainActivityScreen> {
            buttonDialogWebView {
                scrollTo()
                click()
            }
        }
        onScreen<DialogWebViewMainScreen> {
            buttonChangeLanguage { click() }
        }
        onScreen<DialogWebViewLanguageChooserScreen> {
            buttonThai { click() }
        }
        onScreen<DialogWebViewMainScreen> {
            buttonShowWebsite { click() }
        }
        onScreen<DialogWebViewSiteScreen> {
            webViewContent {
                withElement(Locator.ID, "content") {
                    hasText(ExpectedContent.HELLO_WORLD_THAI)
                }
            }
            buttonBack { click() }
        }
        onScreen<DialogWebViewMainScreen> {
            buttonBack { click() }
        }
        onScreen<MainActivityScreen> {
            textViewTitle {
                hasText(ExpectedContent.HELLO_WORLD_THAI)
            }
        }
        // Hebrew
        onScreen<MainActivityScreen> {
            buttonDialogWebView {
                scrollTo()
                click()
            }
        }
        onScreen<DialogWebViewMainScreen> {
            buttonChangeLanguage { click() }
        }
        onScreen<DialogWebViewLanguageChooserScreen> {
            buttonHebrew { click() }
        }
        onScreen<DialogWebViewMainScreen> {
            buttonShowWebsite { click() }
        }
        onScreen<DialogWebViewSiteScreen> {
            webViewContent {
                withElement(Locator.ID, "content") {
                    hasText(ExpectedContent.HELLO_WORLD_HEBREW)
                }
            }
            buttonBack { click() }
        }
        onScreen<DialogWebViewMainScreen> {
            buttonBack { click() }
        }
        onScreen<MainActivityScreen> {
            textViewTitle {
                hasText(ExpectedContent.HELLO_WORLD_HEBREW)
            }
        }
        // American
        onScreen<MainActivityScreen> {
            buttonDialogWebView {
                scrollTo()
                click()
            }
        }
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
