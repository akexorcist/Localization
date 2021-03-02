package com.akexorcist.localizationapp.hilt

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class HiltModule {

    @Binds
    abstract fun bindStoryProvider(provider: SimpleStoryProvider): StoryProvider
}
