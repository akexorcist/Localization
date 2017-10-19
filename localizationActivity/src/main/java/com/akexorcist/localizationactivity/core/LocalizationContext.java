package com.akexorcist.localizationactivity.core;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * Created by Akexorcist on 10/19/2017 AD.
 */

public class LocalizationContext extends ContextWrapper {
    public LocalizationContext(Context base) {
        super(base);
    }

    @Override
    public Resources getResources() {
        Configuration conf = super.getResources().getConfiguration();
        conf.locale = LanguageSetting.getLanguage(this);
        DisplayMetrics metrics = super.getResources().getDisplayMetrics();
        return new Resources(getAssets(), metrics, conf);
    }
}
