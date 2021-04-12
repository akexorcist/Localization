package com.akexorcist.localizationactivity.core

import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.os.LocaleList

fun Context.toLocalizedContext(): Context = LocalizationUtility.applyLocalizationConfig(this)
