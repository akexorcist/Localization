package com.akexorcist.localizationactivity.core

import android.content.Context

/**
 * Created by Aleksander Mielczarek on 03.04.2016.
 */
class LocalizationApplicationDelegate {

    fun onConfigurationChanged(context: Context) = LocalizationUtility.applyLocalizationContext(context)

    fun attachBaseContext(context: Context): Context = LocalizationUtility.applyLocalizationContext(context)

    fun getApplicationContext(applicationContext: Context): Context = LocalizationUtility.applyLocalizationContext(applicationContext)
}
