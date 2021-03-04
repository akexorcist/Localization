package com.akexorcist.localizationapp

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import com.agoda.kakao.screen.Screen.Companion.onScreen
import com.akexorcist.localizationapp.data.ExpectedContent
import com.akexorcist.localizationapp.screen.MainActivityScreen
import com.akexorcist.localizationapp.screen.ViewPagerScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class ViewPagerTest {
    @JvmField
    val uiDevices: UiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    @Rule
    @JvmField
    val rule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun viewPager() {
        onScreen<MainActivityScreen> {
            buttonViewPager {
                scrollTo()
                click()
            }
        }
        // Chinese
        onScreen<ViewPagerScreen> {
            buttonChinese {
                scrollTo()
                click()
            }
            textViewOne {
                hasText(ExpectedContent.ONE_CHINESE)
            }
            buttonNext { click() }
            textViewTwo {
                hasText(ExpectedContent.TWO_CHINESE)
            }
            buttonNext { click() }
            textViewThree {
                hasText(ExpectedContent.THREE_CHINESE)
            }
            buttonNext { click() }
            textViewHello {
                hasText(ExpectedContent.HELLO_WORLD_CHINESE)
                uiDevices.setOrientationRight()
                hasText(ExpectedContent.HELLO_WORLD_CHINESE)
            }
            buttonPrevious { click() }
            textViewThree {
                hasText(ExpectedContent.THREE_CHINESE)
            }
            buttonPrevious { click() }
            textViewTwo {
                hasText(ExpectedContent.TWO_CHINESE)
            }
            buttonPrevious { click() }
            textViewOne {
                hasText(ExpectedContent.ONE_CHINESE)
            }
            pressBack()
        }
        onScreen<MainActivityScreen> {
            textViewTitle {
                hasText(ExpectedContent.HELLO_WORLD_CHINESE)
                uiDevices.setOrientationNatural()
                hasText(ExpectedContent.HELLO_WORLD_CHINESE)
            }
            buttonViewPager {
                scrollTo()
                click()
            }
        }
        // Italian
        onScreen<ViewPagerScreen> {
            buttonItalian {
                scrollTo()
                click()
            }
            textViewOne {
                hasText(ExpectedContent.ONE_ITALIAN)
            }
            buttonNext { click() }
            textViewTwo {
                hasText(ExpectedContent.TWO_ITALIAN)
            }
            buttonNext { click() }
            textViewThree {
                hasText(ExpectedContent.THREE_ITALIAN)
            }
            buttonNext { click() }
            textViewHello {
                hasText(ExpectedContent.HELLO_WORLD_ITALIAN)
                uiDevices.setOrientationRight()
                hasText(ExpectedContent.HELLO_WORLD_ITALIAN)
            }
            buttonPrevious { click() }
            textViewThree {
                hasText(ExpectedContent.THREE_ITALIAN)
            }
            buttonPrevious { click() }
            textViewTwo {
                hasText(ExpectedContent.TWO_ITALIAN)
            }
            buttonPrevious { click() }
            textViewOne {
                hasText(ExpectedContent.ONE_ITALIAN)
            }
            pressBack()
        }
        onScreen<MainActivityScreen> {
            textViewTitle {
                hasText(ExpectedContent.HELLO_WORLD_ITALIAN)
                uiDevices.setOrientationNatural()
                hasText(ExpectedContent.HELLO_WORLD_ITALIAN)
            }
            buttonViewPager {
                scrollTo()
                click()
            }
        }
        // Japanese
        onScreen<ViewPagerScreen> {
            buttonJapanese {
                scrollTo()
                click()
            }
            textViewOne {
                hasText(ExpectedContent.ONE_JAPANESE)
            }
            buttonNext { click() }
            textViewTwo {
                hasText(ExpectedContent.TWO_JAPANESE)
            }
            buttonNext { click() }
            textViewThree {
                hasText(ExpectedContent.THREE_JAPANESE)
            }
            buttonNext { click() }
            textViewHello {
                hasText(ExpectedContent.HELLO_WORLD_JAPANESE)
                uiDevices.setOrientationRight()
                hasText(ExpectedContent.HELLO_WORLD_JAPANESE)
            }
            buttonPrevious { click() }
            textViewThree {
                hasText(ExpectedContent.THREE_JAPANESE)
            }
            buttonPrevious { click() }
            textViewTwo {
                hasText(ExpectedContent.TWO_JAPANESE)
            }
            buttonPrevious { click() }
            textViewOne {
                hasText(ExpectedContent.ONE_JAPANESE)
            }
            pressBack()
        }
        onScreen<MainActivityScreen> {
            textViewTitle {
                hasText(ExpectedContent.HELLO_WORLD_JAPANESE)
                uiDevices.setOrientationNatural()
                hasText(ExpectedContent.HELLO_WORLD_JAPANESE)
            }
            buttonViewPager {
                scrollTo()
                click()
            }
        }
        // Korean
        onScreen<ViewPagerScreen> {
            buttonKorean {
                scrollTo()
                click()
            }
            textViewOne {
                hasText(ExpectedContent.ONE_KOREAN)
            }
            buttonNext { click() }
            textViewTwo {
                hasText(ExpectedContent.TWO_KOREAN)
            }
            buttonNext { click() }
            textViewThree {
                hasText(ExpectedContent.THREE_KOREAN)
            }
            buttonNext { click() }
            textViewHello {
                hasText(ExpectedContent.HELLO_WORLD_KOREAN)
                uiDevices.setOrientationRight()
                hasText(ExpectedContent.HELLO_WORLD_KOREAN)
            }
            buttonPrevious { click() }
            textViewThree {
                hasText(ExpectedContent.THREE_KOREAN)
            }
            buttonPrevious { click() }
            textViewTwo {
                hasText(ExpectedContent.TWO_KOREAN)
            }
            buttonPrevious { click() }
            textViewOne {
                hasText(ExpectedContent.ONE_KOREAN)
            }
            pressBack()
        }
        onScreen<MainActivityScreen> {
            textViewTitle {
                hasText(ExpectedContent.HELLO_WORLD_KOREAN)
                uiDevices.setOrientationNatural()
                hasText(ExpectedContent.HELLO_WORLD_KOREAN)
            }
            buttonViewPager {
                scrollTo()
                click()
            }
        }
        // Portuguese
        onScreen<ViewPagerScreen> {
            buttonPortuguese {
                scrollTo()
                click()
            }
            textViewOne {
                hasText(ExpectedContent.ONE_PORTUGUESE)
            }
            buttonNext { click() }
            textViewTwo {
                hasText(ExpectedContent.TWO_PORTUGUESE)
            }
            buttonNext { click() }
            textViewThree {
                hasText(ExpectedContent.THREE_PORTUGUESE)
            }
            buttonNext { click() }
            textViewHello {
                hasText(ExpectedContent.HELLO_WORLD_PORTUGUESE)
                uiDevices.setOrientationRight()
                hasText(ExpectedContent.HELLO_WORLD_PORTUGUESE)
            }
            buttonPrevious { click() }
            textViewThree {
                hasText(ExpectedContent.THREE_PORTUGUESE)
            }
            buttonPrevious { click() }
            textViewTwo {
                hasText(ExpectedContent.TWO_PORTUGUESE)
            }
            buttonPrevious { click() }
            textViewOne {
                hasText(ExpectedContent.ONE_PORTUGUESE)
            }
            pressBack()
        }
        onScreen<MainActivityScreen> {
            textViewTitle {
                hasText(ExpectedContent.HELLO_WORLD_PORTUGUESE)
                uiDevices.setOrientationNatural()
                hasText(ExpectedContent.HELLO_WORLD_PORTUGUESE)
            }
            buttonViewPager {
                scrollTo()
                click()
            }
        }
        // Thai
        onScreen<ViewPagerScreen> {
            buttonThai {
                scrollTo()
                click()
            }
            textViewOne {
                hasText(ExpectedContent.ONE_THAI)
            }
            buttonNext { click() }
            textViewTwo {
                hasText(ExpectedContent.TWO_THAI)
            }
            buttonNext { click() }
            textViewThree {
                hasText(ExpectedContent.THREE_THAI)
            }
            buttonNext { click() }
            textViewHello {
                hasText(ExpectedContent.HELLO_WORLD_THAI)
                uiDevices.setOrientationRight()
                hasText(ExpectedContent.HELLO_WORLD_THAI)
            }
            buttonPrevious { click() }
            textViewThree {
                hasText(ExpectedContent.THREE_THAI)
            }
            buttonPrevious { click() }
            textViewTwo {
                hasText(ExpectedContent.TWO_THAI)
            }
            buttonPrevious { click() }
            textViewOne {
                hasText(ExpectedContent.ONE_THAI)
            }
            pressBack()
        }
        onScreen<MainActivityScreen> {
            textViewTitle {
                hasText(ExpectedContent.HELLO_WORLD_THAI)
                uiDevices.setOrientationNatural()
                hasText(ExpectedContent.HELLO_WORLD_THAI)
            }
            buttonViewPager {
                scrollTo()
                click()
            }
        }
        // American
        onScreen<ViewPagerScreen> {
            buttonAmerican {
                scrollTo()
                click()
            }
            textViewOne {
                hasText(ExpectedContent.ONE_AMERICAN)
            }
            buttonNext { click() }
            textViewTwo {
                hasText(ExpectedContent.TWO_AMERICAN)
            }
            buttonNext { click() }
            textViewThree {
                hasText(ExpectedContent.THREE_AMERICAN)
            }
            buttonNext { click() }
            textViewHello {
                hasText(ExpectedContent.HELLO_WORLD_AMERICAN)
                uiDevices.setOrientationRight()
                hasText(ExpectedContent.HELLO_WORLD_AMERICAN)
            }
            buttonPrevious { click() }
            textViewThree {
                hasText(ExpectedContent.THREE_AMERICAN)
            }
            buttonPrevious { click() }
            textViewTwo {
                hasText(ExpectedContent.TWO_AMERICAN)
            }
            buttonPrevious { click() }
            textViewOne {
                hasText(ExpectedContent.ONE_AMERICAN)
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
