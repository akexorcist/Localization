package com.akexorcist.localizationapp.stackedactivity

import android.content.Intent
import android.os.Bundle
import com.akexorcist.localizationactivity.ui.LocalizationActivity
import com.akexorcist.localizationapp.databinding.ActivityStack1Binding

class Stack1Activity : LocalizationActivity() {
    private val binding: ActivityStack1Binding by lazy { ActivityStack1Binding.inflate(layoutInflater) }

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener { super.onBackPressed() }
        binding.btnChangeLanguage.setOnClickListener {
            startActivity(Intent(this, Stack2Activity::class.java))
        }
    }
}
