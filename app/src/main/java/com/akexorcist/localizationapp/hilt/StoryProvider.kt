package com.akexorcist.localizationapp.hilt

import android.content.Context
import com.akexorcist.localizationapp.R
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

interface StoryProvider {
    fun getAppleStory(): String
}

class SimpleStoryProvider @Inject constructor(
    @ActivityContext private val context: Context
) : StoryProvider {
    override fun getAppleStory(): String {
        return context.getString(R.string.sample_apple_story)
    }
}
