package com.akexorcist.localizationapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.akexorcist.localizationactivity.LocalizationActivity;
import com.akexorcist.localizationapp.customactivity.SimpleCustomActivity;
import com.akexorcist.localizationapp.simpleactivity.SimpleActivity;
import com.akexorcist.localizationapp.simplefragment.SimpleFragmentActivity;
import com.akexorcist.localizationapp.stackedactivity.Stack1Activity;
import com.akexorcist.localizationapp.viewpager.ViewPagerActivity;

public class MainActivity extends LocalizationActivity implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // You can set default language when first time running. Must to setup before onCreate was called.
        setDefaultLanguage("th");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_simple_activity).setOnClickListener(this);
        findViewById(R.id.btn_custom_activity).setOnClickListener(this);
        findViewById(R.id.btn_stacked_activity).setOnClickListener(this);
        findViewById(R.id.btn_activity_fragment).setOnClickListener(this);
        findViewById(R.id.btn_activity_view_pager).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_simple_activity) {
            goToActivity(SimpleActivity.class);
        } else if (id == R.id.btn_custom_activity) {
            goToActivity(SimpleCustomActivity.class);
        } else if (id == R.id.btn_stacked_activity) {
            goToActivity(Stack1Activity.class);
        } else if (id == R.id.btn_activity_fragment) {
            goToActivity(SimpleFragmentActivity.class);
        } else if (id == R.id.btn_activity_view_pager) {
            goToActivity(ViewPagerActivity.class);
        }
    }

    public void goToActivity(Class<?> activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }
}
