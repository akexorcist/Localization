package com.akexorcist.localizationapp.dialogwebview

import android.content.Intent
import android.os.Bundle
import com.akexorcist.localizationactivity.ui.LocalizationActivity
import com.akexorcist.localizationapp.databinding.ActivityDialogWebviewMainBinding

class DialogWebViewMainActivity : LocalizationActivity() {
    private val binding: ActivityDialogWebviewMainBinding by lazy { ActivityDialogWebviewMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener { super.onBackPressed() }
        binding.btnShowWebsite.setOnClickListener {
            startActivity(Intent(this, DialogWebViewSiteActivity::class.java))
        }
        binding.btnChangeLanguage.setOnClickListener {
            DialogWebViewLanguageChooserFragment.newInstance().show(supportFragmentManager, null)
        }
    }
}
