package com.akexorcist.localizationapp.stackedactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.akexorcist.localizationactivity.ui.LocalizationActivity;
import com.akexorcist.localizationapp.R;

/**
 * Created by Akexorcist on 2/3/2017 AD.
 */

public class Stack1Activity extends LocalizationActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack_1);

        findViewById(R.id.btn_change_language).setOnClickListener(openChangeLanguageActivity());
    }

    private View.OnClickListener openChangeLanguageActivity() {
        return view -> startActivity(new Intent(this, Stack2Activity.class));
    }
}
