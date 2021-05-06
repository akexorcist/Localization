package com.akexorcist.localizationapp.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import com.akexorcist.localizationactivity.ui.LocalizationActivity
import com.akexorcist.localizationapp.databinding.ActivitySimpleBroadcastBinding

class SimpleBroadcastActivity : LocalizationActivity() {
    private val binding by lazy { ActivitySimpleBroadcastBinding.inflate(layoutInflater) }

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener { super.onBackPressed() }
        binding.layoutLanguageChooser.btnAmerican.setOnClickListener { onChangeLanguageButtonClicked("en") }
        binding.layoutLanguageChooser.btnChinese.setOnClickListener { onChangeLanguageButtonClicked("zh") }
        binding.layoutLanguageChooser.btnItalian.setOnClickListener { onChangeLanguageButtonClicked("it") }
        binding.layoutLanguageChooser.btnJapanese.setOnClickListener { onChangeLanguageButtonClicked("ja") }
        binding.layoutLanguageChooser.btnKorean.setOnClickListener { onChangeLanguageButtonClicked("ko") }
        binding.layoutLanguageChooser.btnPortuguese.setOnClickListener { onChangeLanguageButtonClicked("pt") }
        binding.layoutLanguageChooser.btnThai.setOnClickListener { onChangeLanguageButtonClicked("th") }
    }

    private fun onChangeLanguageButtonClicked(language: String) {
        setLanguage(language)
        getContentFromBroadcastReceiver()
    }

    private fun getContentFromBroadcastReceiver() {
        val intent = Intent(BroadcastEvent.ACTION_TO_BROADCAST).apply {
            `package` = packageName
        }
        sendBroadcast(intent)
    }

    override fun onStart() {
        super.onStart()
        val filter = IntentFilter(BroadcastEvent.ACTION_TO_ACTIVITY)
        registerReceiver(broadcastReceiver, filter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(broadcastReceiver)
    }

    private val broadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val content = intent.getStringExtra(BroadcastEvent.EXTRA_CONTENT)
            binding.textViewContent.text = content
        }
    }
}
