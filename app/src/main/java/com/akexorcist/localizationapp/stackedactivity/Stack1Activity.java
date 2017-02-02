package com.akexorcist.localizationapp.stackedactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.akexorcist.localizationactivity.LocalizationActivity;
import com.akexorcist.localizationapp.R;

/**
 * Created by Akexorcist on 2/3/2017 AD.
 */

public class Stack1Activity extends LocalizationActivity implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack_1);

        findViewById(R.id.btn_change_language).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_change_language) {
            openChangeLanguageActivity();
        }
    }

    private void openChangeLanguageActivity() {
        startActivity(new Intent(this, Stack2Activity.class));
    }
}
