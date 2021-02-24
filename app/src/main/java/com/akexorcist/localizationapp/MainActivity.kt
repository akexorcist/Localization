package com.akexorcist.localizationapp

import android.content.Intent
import android.os.Bundle
import com.akexorcist.localizationactivity.ui.LocalizationActivity
import com.akexorcist.localizationapp.customactivity.SimpleCustomActivity
import com.akexorcist.localizationapp.darktheme.DarkThemeActivity
import com.akexorcist.localizationapp.databinding.ActivityMainBinding
import com.akexorcist.localizationapp.nestedfragment.NestedFragmentActivity
import com.akexorcist.localizationapp.preferences.ListPreferencesActivity
import com.akexorcist.localizationapp.simpleactivity.SimpleActivity
import com.akexorcist.localizationapp.simplefragment.SimpleFragmentActivity
import com.akexorcist.localizationapp.stackedactivity.Stack1Activity
import com.akexorcist.localizationapp.viewpager.ViewPagerActivity

class MainActivity : LocalizationActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.textViewTitle.text = applicationContext.getString(R.string.hello_world)
        binding.btnSimpleActivity.setOnClickListener { goToActivity(SimpleActivity::class.java) }
        binding.btnCustomActivity.setOnClickListener { goToActivity(SimpleCustomActivity::class.java) }
        binding.btnStackedActivity.setOnClickListener { goToActivity(Stack1Activity::class.java) }
        binding.btnActivityFragment.setOnClickListener { goToActivity(SimpleFragmentActivity::class.java) }
        binding.btnActivityNestedFragment.setOnClickListener { goToActivity(NestedFragmentActivity::class.java) }
        binding.btnActivityViewPager.setOnClickListener { goToActivity(ViewPagerActivity::class.java) }
        binding.btnActivityListPreferences.setOnClickListener { goToActivity(ListPreferencesActivity::class.java) }
        binding.btnDarkTheme.setOnClickListener { goToActivity(DarkThemeActivity::class.java) }
    }

    private fun goToActivity(activity: Class<*>?) {
        startActivity(Intent(this, activity))
    }
}
