package com.akexorcist.localizationapp

import android.content.Intent
import android.os.Bundle
import com.akexorcist.localizationactivity.ui.LocalizationActivity
import com.akexorcist.localizationapp.broadcast.SimpleBroadcastActivity
import com.akexorcist.localizationapp.customactivity.SimpleCustomActivity
import com.akexorcist.localizationapp.darktheme.DarkThemeActivity
import com.akexorcist.localizationapp.databinding.ActivityMainBinding
import com.akexorcist.localizationapp.dialogwebview.DialogWebViewMainActivity
import com.akexorcist.localizationapp.simpledialog.SimpleDialogMainActivity
import com.akexorcist.localizationapp.hilt.HiltActivity
import com.akexorcist.localizationapp.nestedfragment.NestedFragmentActivity
import com.akexorcist.localizationapp.preferences.ListPreferencesActivity
import com.akexorcist.localizationapp.simpleactivity.SimpleActivity
import com.akexorcist.localizationapp.simplefragment.SimpleFragmentActivity
import com.akexorcist.localizationapp.stackedactivity.StackedHomeActivity
import com.akexorcist.localizationapp.viewpager.ViewPagerActivity

class MainActivity : LocalizationActivity() {
    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.textViewTitle.setText(R.string.hello_world)
        binding.btnSimpleActivity.setOnClickListener { goToActivity(SimpleActivity::class.java) }
        binding.btnCustomActivity.setOnClickListener { goToActivity(SimpleCustomActivity::class.java) }
        binding.btnStackedActivity.setOnClickListener { goToActivity(StackedHomeActivity::class.java) }
        binding.btnSimpleFragment.setOnClickListener { goToActivity(SimpleFragmentActivity::class.java) }
        binding.btnNestedFragment.setOnClickListener { goToActivity(NestedFragmentActivity::class.java) }
        binding.btnDialogFragment.setOnClickListener { goToActivity(SimpleDialogMainActivity::class.java) }
        binding.btnDialogWebView.setOnClickListener { goToActivity(DialogWebViewMainActivity::class.java) }
        binding.btnViewPager.setOnClickListener { goToActivity(ViewPagerActivity::class.java) }
        binding.btnListPreferences.setOnClickListener { goToActivity(ListPreferencesActivity::class.java) }
        binding.btnDarkTheme.setOnClickListener { goToActivity(DarkThemeActivity::class.java) }
        binding.btnHilt.setOnClickListener { goToActivity(HiltActivity::class.java) }
        binding.btnBroadcastReceiver.setOnClickListener { goToActivity(SimpleBroadcastActivity::class.java) }
    }

    private fun goToActivity(activity: Class<*>?) {
        startActivity(Intent(this, activity))
    }
}
