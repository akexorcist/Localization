package com.akexorcist.localizationapp


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import androidx.test.uiautomator.UiDevice
import junit.framework.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class ViewPagerTest {
    @JvmField
    val uiDevices: UiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun viewPager() {
        val appCompatButton = onView(withId(R.id.btn_activity_view_pager))
        appCompatButton.perform(scrollTo(), click())

        val appCompatImageButton = onView(withId(R.id.btn_china))
        appCompatImageButton.perform(scrollTo(), click())

        Thread.sleep(200)

        val textView = onView(withId(R.id.textViewOne))
        textView.check(matches(withText("一")))

        val appCompatButton2 = onView(withId(R.id.btn_next))
        appCompatButton2.perform(click())
        appCompatButton2.perform(click())
        appCompatButton2.perform(click())

        val textView2 = onView(withId(R.id.textViewHello))
        textView2.check(matches(withText("您好世界")))

        uiDevices.setOrientationRight()

        Thread.sleep(200)

        textView2.check(matches(withText("您好世界")))

        pressBack()

        Thread.sleep(200)

        val textView3 = onView(withId(R.id.textViewTitle))
        textView3.check(matches(withText("您好世界")))
        assertEquals(mActivityTestRule.activity.getString(R.string.hello_world), "您好世界")
        assertEquals(mActivityTestRule.activity.baseContext.getString(R.string.hello_world), "您好世界")
        assertEquals(mActivityTestRule.activity.applicationContext.getString(R.string.hello_world), "您好世界")

        uiDevices.setOrientationNatural()

        Thread.sleep(200)

        val appCompatButton5 = onView(withId(R.id.btn_activity_view_pager))
        appCompatButton5.perform(scrollTo(), click())

        val textView4 = onView(withId(R.id.textViewOne))
        textView4.check(matches(withText("一")))

        val appCompatImageButton2 = onView(withId(R.id.btn_italy))
        appCompatImageButton2.perform(scrollTo(), click())

        Thread.sleep(200)

        val textView5 = onView(withId(R.id.textViewOne))
        textView5.check(matches(withText("Uno")))

        val appCompatButton6 = onView(withId(R.id.btn_next))
        appCompatButton6.perform(click())
        appCompatButton6.perform(click())
        appCompatButton6.perform(click())

        val textView6 = onView(withId(R.id.textViewHello))
        textView6.check(matches(withText("Ciao mondo")))

        uiDevices.setOrientationRight()

        Thread.sleep(200)

        textView6.check(matches(withText("Ciao mondo")))

        pressBack()

        Thread.sleep(200)

        val textView7 = onView(withId(R.id.textViewTitle))
        textView7.check(matches(withText("Ciao mondo")))
        assertEquals(mActivityTestRule.activity.getString(R.string.hello_world), "Ciao mondo")
        assertEquals(mActivityTestRule.activity.baseContext.getString(R.string.hello_world), "Ciao mondo")
        assertEquals(mActivityTestRule.activity.applicationContext.getString(R.string.hello_world), "Ciao mondo")

        uiDevices.setOrientationNatural()

        Thread.sleep(200)

        val appCompatButton9 = onView(withId(R.id.btn_activity_view_pager))
        appCompatButton9.perform(scrollTo(), click())

        val textView8 = onView(withId(R.id.textViewOne))
        textView8.check(matches(withText("Uno")))

        val appCompatImageButton3 = onView(withId(R.id.btn_japan))
        appCompatImageButton3.perform(scrollTo(), click())

        Thread.sleep(200)

        val textView9 = onView(withId(R.id.textViewOne))
        textView9.check(matches(withText("一")))

        val appCompatButton10 = onView(withId(R.id.btn_next))
        appCompatButton10.perform(click())
        appCompatButton10.perform(click())
        appCompatButton10.perform(click())

        val textView10 = onView(withId(R.id.textViewHello))
        textView10.check(matches(withText("こんにちは世界")))

        pressBack()

        Thread.sleep(200)

        val textView11 = onView(withId(R.id.textViewTitle))
        textView11.check(matches(withText("こんにちは世界")))
        assertEquals(mActivityTestRule.activity.getString(R.string.hello_world), "こんにちは世界")
        assertEquals(mActivityTestRule.activity.baseContext.getString(R.string.hello_world), "こんにちは世界")
        assertEquals(mActivityTestRule.activity.applicationContext.getString(R.string.hello_world), "こんにちは世界")

        val appCompatButton13 = onView(withId(R.id.btn_activity_view_pager))
        appCompatButton13.perform(scrollTo(), click())

        val textView12 = onView(withId(R.id.textViewOne))
        textView12.check(matches(withText("一")))

        val appCompatImageButton4 = onView(withId(R.id.btn_korea))
        appCompatImageButton4.perform(scrollTo(), click())

        Thread.sleep(200)

        val textView13 = onView(withId(R.id.textViewOne))
        textView13.check(matches(withText("하나")))

        val appCompatButton14 = onView(withId(R.id.btn_next))
        appCompatButton14.perform(click())
        appCompatButton14.perform(click())
        appCompatButton14.perform(click())

        val textView14 = onView(withId(R.id.textViewHello))
        textView14.check(matches(withText("안녕하세요세계")))

        uiDevices.setOrientationRight()

        Thread.sleep(200)

        textView14.check(matches(withText("안녕하세요세계")))

        pressBack()

        Thread.sleep(200)

        val textView15 = onView(withId(R.id.textViewTitle))
        textView15.check(matches(withText("안녕하세요세계")))
        assertEquals(mActivityTestRule.activity.getString(R.string.hello_world), "안녕하세요세계")
        assertEquals(mActivityTestRule.activity.baseContext.getString(R.string.hello_world), "안녕하세요세계")
        assertEquals(mActivityTestRule.activity.applicationContext.getString(R.string.hello_world), "안녕하세요세계")

        uiDevices.setOrientationNatural()

        Thread.sleep(200)

        val appCompatButton17 = onView(withId(R.id.btn_activity_view_pager))
        appCompatButton17.perform(scrollTo(), click())

        val textView16 = onView(withId(R.id.textViewOne))
        textView16.check(matches(withText("하나")))

        val appCompatImageButton5 = onView(withId(R.id.btn_portugal))
        appCompatImageButton5.perform(scrollTo(), click())

        Thread.sleep(200)

        val textView17 = onView(withId(R.id.textViewOne))
        textView17.check(matches(withText("Um")))

        val appCompatButton18 = onView(withId(R.id.btn_next))
        appCompatButton18.perform(click())
        appCompatButton18.perform(click())
        appCompatButton18.perform(click())

        val textView18 = onView(withId(R.id.textViewHello))
        textView18.check(matches(withText("Olá mundo")))

        uiDevices.setOrientationRight()

        Thread.sleep(200)

        textView18.check(matches(withText("Olá mundo")))

        pressBack()

        Thread.sleep(200)

        val textView19 = onView(withId(R.id.textViewTitle))
        textView19.check(matches(withText("Olá mundo")))
        assertEquals(mActivityTestRule.activity.getString(R.string.hello_world), "Olá mundo")
        assertEquals(mActivityTestRule.activity.baseContext.getString(R.string.hello_world), "Olá mundo")
        assertEquals(mActivityTestRule.activity.applicationContext.getString(R.string.hello_world), "Olá mundo")

        uiDevices.setOrientationNatural()

        Thread.sleep(200)

        val appCompatButton21 = onView(withId(R.id.btn_activity_view_pager))
        appCompatButton21.perform(scrollTo(), click())

        val textView20 = onView(withId(R.id.textViewOne))
        textView20.check(matches(withText("Um")))

        val appCompatImageButton6 = onView(withId(R.id.btn_thai))
        appCompatImageButton6.perform(scrollTo(), click())

        Thread.sleep(200)

        val textView21 = onView(withId(R.id.textViewOne))
        textView21.check(matches(withText("หนึ่ง")))

        val appCompatButton22 = onView(withId(R.id.btn_next))
        appCompatButton22.perform(click())
        appCompatButton22.perform(click())
        appCompatButton22.perform(click())

        val textView22 = onView(withId(R.id.textViewHello))
        textView22.check(matches(withText("สวัสดีชาวโลก")))

        uiDevices.setOrientationRight()

        Thread.sleep(200)

        textView22.check(matches(withText("สวัสดีชาวโลก")))

        pressBack()

        Thread.sleep(200)

        val textView23 = onView(withId(R.id.textViewTitle))
        textView23.check(matches(withText("สวัสดีชาวโลก")))
        assertEquals(mActivityTestRule.activity.getString(R.string.hello_world), "สวัสดีชาวโลก")
        assertEquals(mActivityTestRule.activity.baseContext.getString(R.string.hello_world), "สวัสดีชาวโลก")
        assertEquals(mActivityTestRule.activity.applicationContext.getString(R.string.hello_world), "สวัสดีชาวโลก")

        uiDevices.setOrientationNatural()

        Thread.sleep(200)

        val appCompatButton25 = onView(withId(R.id.btn_activity_view_pager))
        appCompatButton25.perform(scrollTo(), click())

        val textView24 = onView(withId(R.id.textViewOne))
        textView24.check(matches(withText("หนึ่ง")))

        val appCompatImageButton7 = onView(withId(R.id.btn_america))
        appCompatImageButton7.perform(scrollTo(), click())

        Thread.sleep(200)

        val textView25 = onView(withId(R.id.textViewOne))
        textView25.check(matches(withText("One")))

        val appCompatButton26 = onView(withId(R.id.btn_next))
        appCompatButton26.perform(click())
        appCompatButton26.perform(click())
        appCompatButton26.perform(click())

        val textView26 = onView(withId(R.id.textViewHello))
        textView26.check(matches(withText("Hello world")))

        uiDevices.setOrientationRight()

        Thread.sleep(200)

        textView26.check(matches(withText("Hello world")))

        pressBack()

        Thread.sleep(200)

        val textView27 = onView(withId(R.id.textViewTitle))
        textView27.check(matches(withText("Hello world")))
        assertEquals(mActivityTestRule.activity.getString(R.string.hello_world), "Hello world")
        assertEquals(mActivityTestRule.activity.baseContext.getString(R.string.hello_world), "Hello world")
        assertEquals(mActivityTestRule.activity.applicationContext.getString(R.string.hello_world), "Hello world")

        uiDevices.setOrientationNatural()

        Thread.sleep(200)
    }
}
