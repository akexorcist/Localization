package com.akexorcist.localizationactivity.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.LocaleList;
import android.util.DisplayMetrics;

import com.akexorcist.localizationactivity.ui.BlankDummyActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Akexorcist on 10/19/2017 AD.
 */

public class LocalizationActivityDelegate {
    private static final String KEY_ACTIVITY_LOCALE_CHANGED = "activity_locale_changed";

    // Boolean flag to check that activity was recreated from locale changed.
    private boolean isLocalizationChanged = false;

    // Prepare default language.
    private Locale currentLanguage = LanguageSetting.getDefaultLanguage();

    private final Activity activity;
    private final List<OnLocaleChangedListener> localeChangedListeners = new ArrayList<>();

    public LocalizationActivityDelegate(Activity activity) {
        this.activity = activity;
    }

    public void addOnLocaleChangedListener(OnLocaleChangedListener onLocaleChangedListener) {
        localeChangedListeners.add(onLocaleChangedListener);
    }

    public void onCreate(Bundle savedInstanceState) {
        setupLanguage();
        checkBeforeLocaleChanging();
    }

    // If activity is run to back stack. So we have to check if this activity is resume working.
    public void onResume(final Context context) {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                checkLocaleChange(context);
                checkAfterLocaleChanging();
            }
        });
    }

    public Context attachBaseContext(Context context) {
        Locale locale = LanguageSetting.getLanguage(context);
        Configuration config = context.getResources().getConfiguration();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            config.setLocale(locale);
            LocaleList localeList = new LocaleList(locale);
            LocaleList.setDefault(localeList);
            config.setLocales(localeList);
            return context.createConfigurationContext(config);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            config.setLocale(locale);
            return context.createConfigurationContext(config);
        } else {
            return context;
        }
    }

    public Context getApplicationContext(Context applicationContext) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            return LocalizationUtility.applyLocalizationContext(applicationContext);
        } else {
            return applicationContext;
        }
    }

    public Resources getResources(Resources resources) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            Configuration config = resources.getConfiguration();
            config.locale = LanguageSetting.getLanguage(activity);
            DisplayMetrics metrics = resources.getDisplayMetrics();
            return new Resources(activity.getAssets(), metrics, config);
        } else {
            return resources;
        }
    }

    // Provide method to set application language by country name.
    public final void setLanguage(Context context, String language) {
        Locale locale = new Locale(language);
        setLanguage(context, locale);
    }

    public final void setLanguage(Context context, String language, String country) {
        Locale locale = new Locale(language, country);
        setLanguage(context, locale);
    }

    public final void setLanguage(Context context, Locale locale) {
        if (!isCurrentLanguageSetting(context, locale)) {
            LanguageSetting.setLanguage(activity, locale);
            notifyLanguageChanged();
        }
    }

    public final void setDefaultLanguage(String language) {
        Locale locale = new Locale(language);
        setDefaultLanguage(locale);
    }

    public final void setDefaultLanguage(String language, String country) {
        Locale locale = new Locale(language, country);
        setDefaultLanguage(locale);
    }

    public final void setDefaultLanguage(Locale locale) {
        LanguageSetting.setDefaultLanguage(locale);
    }

    // Get current language
    public final Locale getLanguage(Context context) {
        return LanguageSetting.getLanguage(context);
    }

    // Check that bundle come from locale change.
    // If yes, bundle will obe remove and set boolean flag to "true".
    private void checkBeforeLocaleChanging() {
        boolean isLocalizationChanged = activity.getIntent().getBooleanExtra(KEY_ACTIVITY_LOCALE_CHANGED, false);
        if (isLocalizationChanged) {
            this.isLocalizationChanged = true;
            activity.getIntent().removeExtra(KEY_ACTIVITY_LOCALE_CHANGED);
        }
    }

    // Setup language to locale and language preference.
    // This method will called before onCreate.
    private void setupLanguage() {
        Locale locale = LanguageSetting.getLanguage(activity);
        setupLocale(locale);
        currentLanguage = locale;
        LanguageSetting.setLanguage(activity, locale);
    }

    // Set locale configuration.
    private void setupLocale(Locale locale) {
        updateLocaleConfiguration(activity, locale);
    }


    private void updateLocaleConfiguration(Context context, Locale locale) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
            Configuration config = context.getResources().getConfiguration();
            config.locale = locale;
            DisplayMetrics dm = context.getResources().getDisplayMetrics();
            context.getResources().updateConfiguration(config, dm);
        }
    }

    // Avoid duplicated setup
    private boolean isCurrentLanguageSetting(Context context, Locale locale) {
        return locale.toString().equals(LanguageSetting.getLanguage(context).toString());
    }

    // Let's take it change! (Using recreate method that available on API 11 or more.
    private void notifyLanguageChanged() {
        sendOnBeforeLocaleChangedEvent();
        activity.getIntent().putExtra(KEY_ACTIVITY_LOCALE_CHANGED, true);
        callDummyActivity();
        activity.recreate();
    }

    // Check if locale has change while this activity was run to back stack.
    private void checkLocaleChange(Context context) {
        if (!isCurrentLanguageSetting(context, currentLanguage)) {
            sendOnBeforeLocaleChangedEvent();
            isLocalizationChanged = true;
            callDummyActivity();
            activity.recreate();
        }
    }

    // Call override method if local is really changed
    private void checkAfterLocaleChanging() {
        if (isLocalizationChanged) {
            sendOnAfterLocaleChangedEvent();
            isLocalizationChanged = false;
        }
    }

    private void sendOnBeforeLocaleChangedEvent() {
        for (OnLocaleChangedListener changedListener : localeChangedListeners) {
            changedListener.onBeforeLocaleChanged();
        }
    }

    private void sendOnAfterLocaleChangedEvent() {
        for (OnLocaleChangedListener listener : localeChangedListeners) {
            listener.onAfterLocaleChanged();
        }
    }

    private void callDummyActivity() {
        activity.startActivity(new Intent(activity, BlankDummyActivity.class));
    }
}
