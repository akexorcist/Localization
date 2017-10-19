package com.akexorcist.localizationapp.nestedfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.HorizontalScrollView;

import com.akexorcist.localizationactivity.ui.LocalizationActivity;
import com.akexorcist.localizationapp.R;

/**
 * Created by Akexorcist on 10/15/2017 AD.
 */

public class NestedFragmentActivity extends LocalizationActivity {
    private static final String KEY_SCROLL_X = "scroll_x";

    private HorizontalScrollView svLanguageChooser;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nested_fragment);

        findViewById(R.id.btn_america).setOnClickListener(onAmericaLanguageSelected());
        findViewById(R.id.btn_china).setOnClickListener(onChinaLanguageSelected());
        findViewById(R.id.btn_italy).setOnClickListener(onItalyLanguageSelected());
        findViewById(R.id.btn_japan).setOnClickListener(onJapanLanguageSelected());
        findViewById(R.id.btn_korea).setOnClickListener(onKoreaLanguageSelected());
        findViewById(R.id.btn_portugal).setOnClickListener(onPortugalLanguageSelected());
        findViewById(R.id.btn_thai).setOnClickListener(onThaiLanguageSelected());

        svLanguageChooser = findViewById(R.id.sv_language_chooser);

        if (savedInstanceState == null) {
            Fragment fragment = ParentFragment.newInstance();
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
}
