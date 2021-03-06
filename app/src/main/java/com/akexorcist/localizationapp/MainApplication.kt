package com.akexorcist.localizationapp

import com.akexorcist.localizationactivity.ui.LocalizationApplication
import dagger.hilt.android.HiltAndroidApp
import java.util.*

@HiltAndroidApp
class MainApplication : LocalizationApplication() {
    override fun getDefaultLanguage(): Locale {
        return Locale.ENGLISH
    }
}
