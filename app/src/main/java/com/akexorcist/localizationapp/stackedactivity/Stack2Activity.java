package com.akexorcist.localizationapp.stackedactivity;

import android.os.Bundle;
import android.view.View;

import com.akexorcist.localizationactivity.LocalizationActivity;
import com.akexorcist.localizationapp.R;

/**
 * Created by Akexorcist on 2/3/2017 AD.
 */

public class Stack2Activity extends LocalizationActivity implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack_2);

        findViewById(R.id.btn_america).setOnClickListener(this);
        findViewById(R.id.btn_china).setOnClickListener(this);
        findViewById(R.id.btn_italy).setOnClickListener(this);
        findViewById(R.id.btn_japan).setOnClickListener(this);
        findViewById(R.id.btn_korea).setOnClickListener(this);
        findViewById(R.id.btn_portugal).setOnClickListener(this);
        findViewById(R.id.btn_thai).setOnClickListener(this);
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
