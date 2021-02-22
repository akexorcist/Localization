package com.akexorcist.localizationapp

import com.akexorcist.localizationactivity.ui.LocalizationApplication
import java.util.*

class MainApplication : LocalizationApplication() {
    override fun getDefaultLanguage(): Locale {
        return Locale.ENGLISH
    }
}
