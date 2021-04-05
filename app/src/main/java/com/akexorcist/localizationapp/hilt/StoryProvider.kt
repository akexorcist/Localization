package com.akexorcist.localizationapp.hilt

import android.content.Context
import com.akexorcist.localizationapp.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

interface StoryProvider {
    fun getAppleStory(): String
}

class SimpleStoryProvider @Inject constructor(
    @ApplicationContext private val appContext: Context
) : StoryProvider {
    override fun getAppleStory(): String {
        return appContext.getString(R.string.sample_apple_story)
    }
}
