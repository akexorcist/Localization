package com.akexorcist.localizationapp.preferences

import android.os.Bundle
import com.akexorcist.localizationactivity.ui.LocalizationActivity
import com.akexorcist.localizationapp.R

class ListPreferencesActivity : LocalizationActivity(), LanguagePreferenceFragment.PreferenceChangeListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_preferences)
        supportFragmentManager.beginTransaction().replace(R.id.layoutFragmentContainer, LanguagePreferenceFragment()).commit()
    }

    override fun onLanguagePreferenceChanged(langauge: String) {
        setLanguage(langauge)
    }
}
