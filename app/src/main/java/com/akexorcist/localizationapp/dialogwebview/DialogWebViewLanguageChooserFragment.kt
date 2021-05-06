package com.akexorcist.localizationapp.dialogwebview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.akexorcist.localizationactivity.ui.LocalizationActivity
import com.akexorcist.localizationapp.databinding.FragmentDialogWebviewLanguageChooserBinding

class DialogWebViewLanguageChooserFragment : DialogFragment() {
    private lateinit var binding: FragmentDialogWebviewLanguageChooserBinding

    companion object {
        fun newInstance(): DialogWebViewLanguageChooserFragment = DialogWebViewLanguageChooserFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDialogWebviewLanguageChooserBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAmerican.setOnClickListener { changeLanguage("en") }
        binding.btnChinese.setOnClickListener { changeLanguage("zh") }
        binding.btnItalian.setOnClickListener { changeLanguage("it") }
        binding.btnJapanese.setOnClickListener { changeLanguage("ja") }
        binding.btnKorean.setOnClickListener { changeLanguage("ko") }
        binding.btnPortuguese.setOnClickListener { changeLanguage("pt") }
        binding.btnThai.setOnClickListener { changeLanguage("th") }
    }

    private fun changeLanguage(language: String) {
        (requireActivity() as? LocalizationActivity)?.setLanguage(language)
        dismiss()
    }
}
