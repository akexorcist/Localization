package com.akexorcist.localizationactivity.core

import android.content.Context

fun Context.toLocalizedContext(): Context = LocalizationUtility.getLocalizedContext(this)
