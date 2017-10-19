package com.akexorcist.localizationapp.viewpager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.akexorcist.localizationactivity.ui.LocalizationActivity;
import com.akexorcist.localizationapp.R;

public class ViewPagerActivity extends LocalizationActivity implements ViewPager.OnPageChangeListener {
    private final String KEY_CURRENT_PAGE = "current_page";

    private ViewPagerAdapter adapter;
    private ViewPager vpGreeting;
    private Button btnNext;
    private Button btnPrev;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        findViewById(R.id.btn_america).setOnClickListener(onAmericaLanguageSelected());
        findViewById(R.id.btn_china).setOnClickListener(onChinaLanguageSelected());
        findViewById(R.id.btn_italy).setOnClickListener(onItalyLanguageSelected());
        findViewById(R.id.btn_japan).setOnClickListener(onJapanLanguageSelected());
        findViewById(R.id.btn_korea).setOnClickListener(onKoreaLanguageSelected());
        findViewById(R.id.btn_portugal).setOnClickListener(onPortugalLanguageSelected());
        findViewById(R.id.btn_thai).setOnClickListener(onThaiLanguageSelected());

        btnNext = findViewById(R.id.btn_next);
        btnNext.setOnClickListener(onNextPageClick());

        btnPrev = findViewById(R.id.btn_prev);
        btnPrev.setOnClickListener(onPreviousPageClick());

        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        vpGreeting = findViewById(R.id.vp_greeting);
        vpGreeting.setAdapter(adapter);
        vpGreeting.addOnPageChangeListener(this);

        setNavigationVisibility(vpGreeting.getCurrentItem());
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        // Save current item of view pager.
        outState.putInt(KEY_CURRENT_PAGE, vpGreeting.getCurrentItem());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore current item of view pager.
        vpGreeting.setCurrentItem(savedInstanceState.getInt(KEY_CURRENT_PAGE));
    }

    @Override
    public void onPageSelected(int position) {
        setNavigationVisibility(position);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    private View.OnClickListener onAmericaLanguageSelected() {
        return view -> setLanguage("en");
    }

    private View.OnClickListener onChinaLanguageSelected() {
        return view -> setLanguage("zh");
    }

    private View.OnClickListener onItalyLanguageSelected() {
        return view -> setLanguage("it");
    }

    private View.OnClickListener onJapanLanguageSelected() {
        return view -> setLanguage("ja");
    }

    private View.OnClickListener onKoreaLanguageSelected() {
        return view -> setLanguage("ko");
    }

    private View.OnClickListener onPortugalLanguageSelected() {
        return view -> setLanguage("pt");
    }

    private View.OnClickListener onThaiLanguageSelected() {
        return view -> setLanguage("th");
    }

    private View.OnClickListener onNextPageClick() {
        return view -> vpGreeting.setCurrentItem(vpGreeting.getCurrentItem() + 1);
    }

    private View.OnClickListener onPreviousPageClick() {
        return view -> vpGreeting.setCurrentItem(vpGreeting.getCurrentItem() - 1);
    }

    private void setNavigationVisibility(int currentPosition) {
        btnPrev.setVisibility((currentPosition == 0) ? View.GONE : View.VISIBLE);
        btnNext.setVisibility((currentPosition == adapter.getCount() - 1) ? View.GONE : View.VISIBLE);
    }
}
