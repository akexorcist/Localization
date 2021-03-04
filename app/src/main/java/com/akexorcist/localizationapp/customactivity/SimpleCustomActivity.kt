package com.akexorcist.localizationapp.customactivity

import android.os.Bundle
import com.akexorcist.localizationapp.R
import com.akexorcist.localizationapp.databinding.ActivityCustomBinding

class SimpleCustomActivity : CustomActivity() {
    private val binding: ActivityCustomBinding by lazy { ActivityCustomBinding.inflate(layoutInflater) }

    companion object {
        private const val KEY_SCROLL_X = "scroll_x"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Activity title is not change the language automatically.
        setTitle(R.string.hello_world)
        binding.btnBack.setOnClickListener { super.onBackPressed() }
        binding.layoutLanguageChooser.btnAmerica.setOnClickListener { setLanguage("en") }
        binding.layoutLanguageChooser.btnChina.setOnClickListener { setLanguage("zh") }
        binding.layoutLanguageChooser.btnItaly.setOnClickListener { setLanguage("it") }
        binding.layoutLanguageChooser.btnJapan.setOnClickListener { setLanguage("ja") }
        binding.layoutLanguageChooser.btnKorea.setOnClickListener { setLanguage("ko") }
        binding.layoutLanguageChooser.btnPortugal.setOnClickListener { setLanguage("pt") }
        binding.layoutLanguageChooser.btnThai.setOnClickListener { setLanguage("th") }
    }

    public override fun onSaveInstanceState(outState: Bundle) {
        // Save x-position of horizontal scroll view.
        outState.putInt(KEY_SCROLL_X, binding.layoutLanguageChooser.svLanguageChooser.scrollX)
        super.onSaveInstanceState(outState)
    }

    public override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        // Restore x-position of horizontal scroll view.
        binding.layoutLanguageChooser.svLanguageChooser.scrollTo(
            savedInstanceState.getInt(KEY_SCROLL_X), 0
        )
    }
}
