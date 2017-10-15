/*
 * Copyright (c) 2015 Akexorcist
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.akexorcist.localizationactivity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.Locale;

/**
 * Created by Akexorcist on 7/20/15 AD.
 */
public class LanguageSetting {
    private static final String PREFERENCE_LANGUAGE = "pref_language";
    private static final String KEY_LANGUAGE = "key_language";
    private static Locale DEFAULT_LANGUAGE = Locale.ENGLISH;
    private static Locale currentLanguage = Locale.ENGLISH;

    public static void setDefaultLanguage(Locale locale) {
        DEFAULT_LANGUAGE = locale;
    }

    public static Locale getDefaultLanguage() {
        return DEFAULT_LANGUAGE;
    }

    public static void setLanguage(Context context, Locale locale) {
        currentLanguage = locale;
        SharedPreferences.Editor editor = getLanguagePreference(context).edit();
        editor.putString(KEY_LANGUAGE, locale.toString());
        editor.apply();
    }

    public static Locale getCurrentLanguage() {
        return currentLanguage;
    }

    public static Locale getLanguage(Context context) {
        String[] language = getLanguagePreference(context)
                .getString(KEY_LANGUAGE, DEFAULT_LANGUAGE.toString())
                .split("_");
        Locale locale;
        if (language.length == 1) {
            locale = new Locale(language[0]);
        } else if (language.length == 2) {
            locale = new Locale(language[0], language[1].toUpperCase());
        } else {
            locale = DEFAULT_LANGUAGE;
        }
        return locale;
    }

    private static SharedPreferences getLanguagePreference(Context context) {
        return context.getSharedPreferences(PREFERENCE_LANGUAGE, Activity.MODE_PRIVATE);
    }
}
