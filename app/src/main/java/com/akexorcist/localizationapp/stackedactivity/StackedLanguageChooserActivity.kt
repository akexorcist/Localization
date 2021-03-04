package com.akexorcist.localizationapp.stackedactivity

import android.os.Bundle
import com.akexorcist.localizationactivity.ui.LocalizationActivity
import com.akexorcist.localizationapp.databinding.ActivityStackedLanguageChooserBinding

class StackedLanguageChooserActivity : LocalizationActivity() {
    private val binding: ActivityStackedLanguageChooserBinding by lazy { ActivityStackedLanguageChooserBinding.inflate(layoutInflater) }

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btnAmerican.setOnClickListener { changeLanguage("en") }
        binding.btnChinese.setOnClickListener { changeLanguage("zh") }
        binding.btnItalian.setOnClickListener { changeLanguage("it") }
        binding.btnJapanese.setOnClickListener { changeLanguage("ja") }
        binding.btnKorean.setOnClickListener { changeLanguage("ko") }
        binding.btnPortuguese.setOnClickListener { changeLanguage("pt") }
        binding.btnThai.setOnClickListener { changeLanguage("th") }
    }

    private fun changeLanguage(language: String) {
        setLanguage(language)
        finish()
    }
}
