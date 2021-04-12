package com.akexorcist.localizationapp.simpledialog

import android.content.Intent
import android.os.Bundle
import com.akexorcist.localizationactivity.ui.LocalizationActivity
import com.akexorcist.localizationapp.databinding.ActivitySimpleDialogMainBinding

class SimpleDialogMainActivity : LocalizationActivity() {
    private val binding: ActivitySimpleDialogMainBinding by lazy { ActivitySimpleDialogMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener { super.onBackPressed() }
        binding.btnChangeLanguage.setOnClickListener {
            startActivity(Intent(this, SimpleDialogLanguageChooserActivity::class.java))
        }
        binding.btnShowContent.setOnClickListener {
            SimpleDialogContentFragment.newInstance().show(supportFragmentManager, null)
        }
    }
}
