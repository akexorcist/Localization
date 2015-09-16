package com.akexorcist.localizationapp.simplefragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.HorizontalScrollView;

import com.akexorcist.localizationactivity.LocalizationActivity;
import com.akexorcist.localizationapp.R;

public class SimpleFragmentActivity extends LocalizationActivity implements View.OnClickListener {
    private final String KEY_SCROLL_X = "scroll_x";

    private HorizontalScrollView svLanguageChooser;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_fragment);

        findViewById(R.id.btn_america).setOnClickListener(this);
        findViewById(R.id.btn_china).setOnClickListener(this);
        findViewById(R.id.btn_italy).setOnClickListener(this);
        findViewById(R.id.btn_japan).setOnClickListener(this);
        findViewById(R.id.btn_korea).setOnClickListener(this);
        findViewById(R.id.btn_portugal).setOnClickListener(this);
        findViewById(R.id.btn_thai).setOnClickListener(this);

        svLanguageChooser = (HorizontalScrollView) findViewById(R.id.sv_language_chooser);

        if (savedInstanceState == null) {
            Fragment fragment = SimpleFragment.newInstance();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.layout_fragment_container, fragment);
            transaction.commit();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        // Save x-position of horizontal scroll view.
        outState.putInt(KEY_SCROLL_X, svLanguageChooser.getScrollX());
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Restore x-position of horizontal scroll view.
        svLanguageChooser.scrollTo(savedInstanceState.getInt(KEY_SCROLL_X), 0);
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
        }
    }
}
