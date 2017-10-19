package com.akexorcist.localizationapp.stackedactivity;

import android.os.Bundle;
import android.view.View;

import com.akexorcist.localizationactivity.ui.LocalizationActivity;
import com.akexorcist.localizationapp.R;

/**
 * Created by Akexorcist on 2/3/2017 AD.
 */

public class Stack2Activity extends LocalizationActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack_2);

        findViewById(R.id.btn_america).setOnClickListener(onAmericaLanguageSelected());
        findViewById(R.id.btn_china).setOnClickListener(onChinaLanguageSelected());
        findViewById(R.id.btn_italy).setOnClickListener(onItalyLanguageSelected());
        findViewById(R.id.btn_japan).setOnClickListener(onJapanLanguageSelected());
        findViewById(R.id.btn_korea).setOnClickListener(onKoreaLanguageSelected());
        findViewById(R.id.btn_portugal).setOnClickListener(onPortugalLanguageSelected());
        findViewById(R.id.btn_thai).setOnClickListener(onThaiLanguageSelected());
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
