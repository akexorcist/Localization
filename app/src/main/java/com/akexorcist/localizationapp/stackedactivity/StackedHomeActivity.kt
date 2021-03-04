package com.akexorcist.localizationapp.stackedactivity

import android.content.Intent
import android.os.Bundle
import com.akexorcist.localizationactivity.ui.LocalizationActivity
import com.akexorcist.localizationapp.databinding.ActivityStackedHomeBinding

class StackedHomeActivity : LocalizationActivity() {
    private val binding: ActivityStackedHomeBinding by lazy { ActivityStackedHomeBinding.inflate(layoutInflater) }

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener { super.onBackPressed() }
        binding.btnChangeLanguage.setOnClickListener {
            startActivity(Intent(this, StackedLanguageChooserActivity::class.java))
        }
    }
}
