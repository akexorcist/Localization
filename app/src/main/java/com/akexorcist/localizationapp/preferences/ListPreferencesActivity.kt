package com.akexorcist.localizationapp.preferences

import android.os.Bundle
import androidx.fragment.app.commit
import com.akexorcist.localizationactivity.ui.LocalizationActivity
import com.akexorcist.localizationapp.databinding.ActivityListPreferencesBinding

class ListPreferencesActivity : LocalizationActivity(), LanguagePreferenceFragment.PreferenceChangeListener {
    private val binding: ActivityListPreferencesBinding by lazy { ActivityListPreferencesBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener { super.onBackPressed() }

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                replace(binding.layoutFragmentContainer.id, LanguagePreferenceFragment.newInstance())
            }
        }
    }

    override fun onLanguagePreferenceChanged(language: String) {
        setLanguage(language)
    }
}
