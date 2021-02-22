package com.akexorcist.localizationapp.preferences

import android.os.Bundle
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import com.akexorcist.localizationapp.R

class LanguagePreferenceFragment : PreferenceFragmentCompat() {
    companion object {
        private const val KEY_PREFERENCE_LANGUAGE = "language"

        fun newInstance() = LanguagePreferenceFragment()
    }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.settings, rootKey)
        setHasOptionsMenu(false)
        findPreference<Preference>(KEY_PREFERENCE_LANGUAGE)?.setOnPreferenceChangeListener { _, newValue ->
            val language = newValue.toString()
            (activity as PreferenceChangeListener).onLanguagePreferenceChanged(language)
            true
        }
    }

    interface PreferenceChangeListener {
        fun onLanguagePreferenceChanged(language: String)
    }
}
