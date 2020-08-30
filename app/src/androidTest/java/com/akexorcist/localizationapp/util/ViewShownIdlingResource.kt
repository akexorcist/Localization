package com.akexorcist.localizationapp.util

import android.view.View
import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.IdlingResource
import androidx.test.espresso.IdlingResource.ResourceCallback
import androidx.test.espresso.ViewFinder
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher

class ViewShownIdlingResource(private val viewMatcher: Matcher<View>) :
    IdlingResource {
    private var resourceCallback: ResourceCallback? = null
    override fun isIdleNow(): Boolean {
        val view = getView(viewMatcher)
        val idle = view == null || view.isShown
        if (idle && resourceCallback != null) {
            resourceCallback?.onTransitionToIdle()
        }
        return idle
    }

    override fun registerIdleTransitionCallback(resourceCallback: ResourceCallback) {
        this.resourceCallback = resourceCallback
    }

    override fun getName(): String {
        return this.toString() + viewMatcher.toString()
    }

    companion object {
        private fun getView(viewMatcher: Matcher<View>): View? {
            return try {
                val viewInteraction = Espresso.onView(viewMatcher)
                val finderField =
                    viewInteraction.javaClass.getDeclaredField("viewFinder")
                finderField.isAccessible = true
                val finder = finderField[viewInteraction] as ViewFinder
                finder.view
            } catch (e: Exception) {
                null
            }
        }
    }
}

fun waitViewShown(matcher: Matcher<View>) {
    val idlingResource: IdlingResource = ViewShownIdlingResource(matcher)
    try {
        IdlingRegistry.getInstance().register(idlingResource)
        Espresso.onView(matcher).check(
            ViewAssertions.matches(
                ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)
            )
        )
    } finally {
        IdlingRegistry.getInstance().unregister(idlingResource)
    }
}