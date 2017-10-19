package com.akexorcist.localizationapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.akexorcist.localizationactivity.ui.LocalizationActivity;
import com.akexorcist.localizationapp.customactivity.SimpleCustomActivity;
import com.akexorcist.localizationapp.nestedfragment.NestedFragmentActivity;
import com.akexorcist.localizationapp.simpleactivity.SimpleActivity;
import com.akexorcist.localizationapp.simplefragment.SimpleFragmentActivity;
import com.akexorcist.localizationapp.stackedactivity.Stack1Activity;
import com.akexorcist.localizationapp.viewpager.ViewPagerActivity;

public class MainActivity extends LocalizationActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // You can set default language when first time running. Must to setup before onCreate was called.
        setDefaultLanguage("th");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_simple_activity).setOnClickListener(onSimpleActivityClick());
        findViewById(R.id.btn_custom_activity).setOnClickListener(onCustomActivityClick());
        findViewById(R.id.btn_stacked_activity).setOnClickListener(onStackedActivityClick());
        findViewById(R.id.btn_activity_fragment).setOnClickListener(onSimpleFragmentClick());
        findViewById(R.id.btn_activity_nested_fragment).setOnClickListener(onNestedFragmentClick());
        findViewById(R.id.btn_activity_view_pager).setOnClickListener(onViewPagerClick());
    }

    public View.OnClickListener onSimpleActivityClick() {
        return view -> goToActivity(SimpleActivity.class);
    }

    public View.OnClickListener onCustomActivityClick() {
        return view -> goToActivity(SimpleCustomActivity.class);
    }

    public View.OnClickListener onStackedActivityClick() {
        return view -> goToActivity(Stack1Activity.class);
    }

    public View.OnClickListener onSimpleFragmentClick() {
        return view -> goToActivity(SimpleFragmentActivity.class);
    }

    private View.OnClickListener onNestedFragmentClick() {
        return view -> goToActivity(NestedFragmentActivity.class);
    }

    public View.OnClickListener onViewPagerClick() {
        return view -> goToActivity(ViewPagerActivity.class);
    }

    public void goToActivity(Class<?> activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }
}
