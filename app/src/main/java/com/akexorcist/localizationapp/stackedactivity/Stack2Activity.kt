package com.akexorcist.localizationapp.stackedactivity

import android.os.Bundle
import com.akexorcist.localizationactivity.ui.LocalizationActivity
import com.akexorcist.localizationapp.databinding.ActivityStack2Binding

class Stack2Activity : LocalizationActivity() {
    private val binding: ActivityStack2Binding by lazy { ActivityStack2Binding.inflate(layoutInflater) }

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btnAmerica.setOnClickListener { changeLanguage("en") }
        binding.btnChina.setOnClickListener { changeLanguage("zh") }
        binding.btnItaly.setOnClickListener { changeLanguage("it") }
        binding.btnJapan.setOnClickListener { changeLanguage("ja") }
        binding.btnKorea.setOnClickListener { changeLanguage("ko") }
        binding.btnPortugal.setOnClickListener { changeLanguage("pt") }
        binding.btnThai.setOnClickListener { changeLanguage("th") }
    }

    private fun changeLanguage(language: String) {
        setLanguage(language)
        finish()
    }
}
