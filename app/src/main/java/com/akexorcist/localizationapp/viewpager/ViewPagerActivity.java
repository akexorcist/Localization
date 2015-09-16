package com.akexorcist.localizationapp.viewpager;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.akexorcist.localizationactivity.LocalizationActivity;
import com.akexorcist.localizationapp.R;

public class ViewPagerActivity extends LocalizationActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private final String KEY_CURRENT_PAGE = "current_page";

    private ViewPagerAdapter adapter;
    private ViewPager vpGreeting;
    private Button btnNext;
    private Button btnPrev;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        findViewById(R.id.btn_america).setOnClickListener(this);
        findViewById(R.id.btn_china).setOnClickListener(this);
        findViewById(R.id.btn_italy).setOnClickListener(this);
        findViewById(R.id.btn_japan).setOnClickListener(this);
        findViewById(R.id.btn_korea).setOnClickListener(this);
        findViewById(R.id.btn_portugal).setOnClickListener(this);
        findViewById(R.id.btn_thai).setOnClickListener(this);

        btnNext = (Button) findViewById(R.id.btn_next);
        btnNext.setOnClickListener(this);

        btnPrev = (Button) findViewById(R.id.btn_prev);
        btnPrev.setOnClickListener(this);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        vpGreeting = (ViewPager) findViewById(R.id.vp_greeting);
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
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_america) {
            setLanguage("en");
        } else if (id == R.id.btn_china) {
            setLanguage("zh");
        } else if (id == R.id.btn_italy) {
            setLanguage("it");
        } else if (id == R.id.btn_japan) {
            setLanguage("ja");
        } else if (id == R.id.btn_korea) {
            setLanguage("ko");
        } else if (id == R.id.btn_portugal) {
            setLanguage("pt");
        } else if (id == R.id.btn_thai) {
            setLanguage("th");
        } else if (id == R.id.btn_next) {
            nextPage();
        } else if (id == R.id.btn_prev) {
            previousPage();
        }
    }

    @Override
    public void onPageSelected(int position) {
        setNavigationVisibility(position);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { }

    @Override
    public void onPageScrollStateChanged(int state) { }

    private void nextPage() {
        vpGreeting.setCurrentItem(vpGreeting.getCurrentItem() + 1);
    }

    private void previousPage() {
        vpGreeting.setCurrentItem(vpGreeting.getCurrentItem() - 1);
    }

    private void setNavigationVisibility(int currentPosition) {
        btnPrev.setVisibility((currentPosition == 0) ? View.GONE : View.VISIBLE);
        btnNext.setVisibility((currentPosition == adapter.getCount() - 1) ? View.GONE : View.VISIBLE);
    }
}
