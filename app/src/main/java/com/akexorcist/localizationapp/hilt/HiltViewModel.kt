package com.akexorcist.localizationapp.hilt

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class HiltViewModel @Inject constructor(val storyProvider: SimpleStoryProvider) : ViewModel(){
    init {
        storyProvider.getAppleStory()
    }
}