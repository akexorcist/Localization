package com.akexorcist.localizationactivity.ui

import android.app.Service
import android.content.Context
import android.content.res.Resources
import com.akexorcist.localizationactivity.core.LocalizationServiceDelegate

abstract class LocalizationService : Service() {
    private val localizationDelegate: LocalizationServiceDelegate by lazy {
        LocalizationServiceDelegate(this)
    }

    override fun getBaseContext(): Context {
        return localizationDelegate.getApplicationContext(super.getBaseContext())
    }

    override fun getApplicationContext(): Context {
        return localizationDelegate.getApplicationContext(super.getApplicationContext())
    }

    override fun getResources(): Resources {
        return localizationDelegate.getResources(super.getResources())
    }
}
