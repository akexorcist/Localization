package com.akexorcist.localizationapp.viewpager

import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.akexorcist.localizationactivity.ui.LocalizationActivity
import com.akexorcist.localizationapp.databinding.ActivityViewPagerBinding

class ViewPagerActivity : LocalizationActivity() {
    private val binding: ActivityViewPagerBinding by lazy { ActivityViewPagerBinding.inflate(layoutInflater) }
    private lateinit var adapter: ViewPagerAdapter

    companion object {
        private const val KEY_CURRENT_PAGE = "current_page"
    }

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener { super.onBackPressed() }
        binding.layoutLanguageChooser.btnAmerican.setOnClickListener { setLanguage("en") }
        binding.layoutLanguageChooser.btnChinese.setOnClickListener { setLanguage("zh") }
        binding.layoutLanguageChooser.btnItalian.setOnClickListener { setLanguage("it") }
        binding.layoutLanguageChooser.btnJapanese.setOnClickListener { setLanguage("ja") }
        binding.layoutLanguageChooser.btnKorean.setOnClickListener { setLanguage("ko") }
        binding.layoutLanguageChooser.btnPortuguese.setOnClickListener { setLanguage("pt") }
        binding.layoutLanguageChooser.btnThai.setOnClickListener { setLanguage("th") }

        binding.btnNext.setOnClickListener { onNextPageClick() }
        binding.btnPrev.setOnClickListener { onPreviousPageClick() }

        adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        binding.vpGreeting.adapter = adapter
        binding.vpGreeting.registerOnPageChangeCallback(onPageChangeCallback)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.vpGreeting.unregisterOnPageChangeCallback(onPageChangeCallback)
    }

    public override fun onSaveInstanceState(outState: Bundle) {
        // Save current item of view pager.
        outState.putInt(KEY_CURRENT_PAGE, binding.vpGreeting.currentItem)
        super.onSaveInstanceState(outState)
    }

    public override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        // Restore current item of view pager.
        binding.vpGreeting.currentItem = savedInstanceState.getInt(KEY_CURRENT_PAGE)
    }

    private val onPageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            setNavigationVisibility(position)
        }
    }

    private fun onNextPageClick() {
        binding.vpGreeting.currentItem = binding.vpGreeting.currentItem + 1
    }

    private fun onPreviousPageClick() {
        binding.vpGreeting.currentItem = binding.vpGreeting.currentItem - 1
    }

    private fun setNavigationVisibility(currentPosition: Int) {
        binding.btnPrev.visibility = if (currentPosition == 0) View.GONE else View.VISIBLE
        binding.btnNext.visibility = if (currentPosition == adapter.itemCount - 1) View.GONE else View.VISIBLE
    }
}
