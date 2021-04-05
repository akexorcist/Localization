package com.akexorcist.localizationapp.hilt

import android.os.Bundle
import com.akexorcist.localizationactivity.ui.LocalizationActivity
import com.akexorcist.localizationapp.databinding.ActivityHiltBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HiltActivity : LocalizationActivity() {
    private val binding: ActivityHiltBinding by lazy { ActivityHiltBinding.inflate(layoutInflater) }

    @Inject
    lateinit var storyProvider: StoryProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}
