package com.akexorcist.localizationactivity.core;

import android.content.Context;

/**
 * Created by Aleksander Mielczarek on 03.04.2016.
 */
public class LocalizationApplicationDelegate {

    public void onConfigurationChanged(Context context) {
        LocalizationUtility.applyLocalizationContext(context);
    }

    public Context attachBaseContext(Context context) {
        return LocalizationUtility.applyLocalizationContext(context);
    }

    public Context getApplicationContext(Context applicationContext) {
        return LocalizationUtility.applyLocalizationContext(applicationContext);
    }

}
