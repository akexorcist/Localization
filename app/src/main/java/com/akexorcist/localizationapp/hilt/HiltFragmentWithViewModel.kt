package com.akexorcist.localizationapp.hilt

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ScrollView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.akexorcist.localizationactivity.ui.LocalizationActivity
import com.akexorcist.localizationapp.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HiltFragmentWithViewModel : Fragment(R.layout.fragment_hilt) {

    private val hiltViewModel: HiltViewModel by viewModels()

    private var languageChooserScrollView: ScrollView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUi(view)
    }

    private fun setupUi(view: View) {
        languageChooserScrollView = view.findViewById(R.id.sv_language_chooser)

        view.findViewById<TextView>(R.id.text_view_content).text = hiltViewModel.storyProvider.getAppleStory()
        view.findViewById<Button>(R.id.btn_back).setOnClickListener { activity?.onBackPressed() }
        view.findViewById<ImageButton>(R.id.btn_american).setOnClickListener { setLanguage("en") }
        view.findViewById<ImageButton>(R.id.btn_chinese).setOnClickListener { setLanguage("zh") }
        view.findViewById<ImageButton>(R.id.btn_italian).setOnClickListener { setLanguage("it") }
        view.findViewById<ImageButton>(R.id.btn_japanese).setOnClickListener { setLanguage("ja") }
        view.findViewById<ImageButton>(R.id.btn_korean).setOnClickListener { setLanguage("ko") }
        view.findViewById<ImageButton>(R.id.btn_portuguese).setOnClickListener { setLanguage("pt") }
        view.findViewById<ImageButton>(R.id.btn_thai).setOnClickListener { setLanguage("th") }
    }

    private fun setLanguage(newLanguage: String) {
        (activity as? LocalizationActivity)?.setLanguage(newLanguage)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        // Save x-position of horizontal scroll view.
        languageChooserScrollView?.scrollX?.let { scrollX ->
            outState.putInt(KEY_SCROLL_X, scrollX)
        }
        super.onSaveInstanceState(outState)
    }


    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        languageChooserScrollView?.scrollTo(savedInstanceState?.getInt(KEY_SCROLL_X) ?: 0, 0)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        languageChooserScrollView = null
    }

    companion object {
        private const val KEY_SCROLL_X = "scroll_x"
    }
}