package com.akexorcist.localizationapp;

import com.akexorcist.localizationactivity.ui.LocalizationApplication;

import org.jetbrains.annotations.NotNull;

import java.util.Locale;

/**
 * Created by Akexorcist on 10/19/2017 AD.
 */

public class MainApplication extends LocalizationApplication {

    @NotNull
    @Override
    public Locale getDefaultLanguage() {
        return Locale.ENGLISH;
    }
}
