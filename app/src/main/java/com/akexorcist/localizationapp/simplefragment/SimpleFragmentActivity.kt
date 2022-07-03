package com.akexorcist.localizationapp.simplefragment

import android.os.Bundle
import androidx.fragment.app.commit
import com.akexorcist.localizationactivity.ui.LocalizationActivity
import com.akexorcist.localizationapp.databinding.ActivitySimpleFragmentBinding

class SimpleFragmentActivity : LocalizationActivity() {
    private val binding: ActivitySimpleFragmentBinding by lazy { ActivitySimpleFragmentBinding.inflate(layoutInflater) }

    companion object {
        private const val KEY_SCROLL_X = "scroll_x"
    }

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener { super.onBackPressed() }
        binding.layoutLanguageChooser.btnAmerican.setOnClickListener { setLanguage("en") }
        binding.layoutLanguageChooser.btnChinese.setOnClickListener { setLanguage("zh") }
        binding.layoutLanguageChooser.btnItalian.setOnClickListener { setLanguage("it") }
        binding.layoutLanguageChooser.btnJapanese.setOnClickListener { setLanguage("ja") }
        binding.layoutLanguageChooser.btnKorean.setOnClickListener { setLanguage("ko") }
        binding.layoutLanguageChooser.btnPortuguese.setOnClickListener { setLanguage("pt") }
        binding.layoutLanguageChooser.btnThai.setOnClickListener { setLanguage("th") }
        binding.layoutLanguageChooser.btnHebrew.setOnClickListener { setLanguage("iw") }

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                replace(binding.layoutFragmentContainer.id, SimpleFragment.newInstance())
            }
        }
    }

    public override fun onSaveInstanceState(outState: Bundle) {
        // Save x-position of horizontal scroll view.
        outState.putInt(KEY_SCROLL_X, binding.layoutLanguageChooser.svLanguageChooser.scrollX)
        super.onSaveInstanceState(outState)
    }

    public override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        // Restore x-position of horizontal scroll view.
        binding.layoutLanguageChooser.svLanguageChooser.scrollTo(savedInstanceState.getInt(KEY_SCROLL_X), 0)
    }
}
