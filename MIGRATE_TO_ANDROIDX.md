# Migrate to AndroidX
Since AndroidX supports per-app language preferences for backward compatibility. Please migrate this library to AndroidX for more stability, compatibility, and longer supports from Google team.  

* AppCompat `1.6.0-alpha03` or higher is required (see [AppCompat release notes](https://developer.android.com/jetpack/androidx/releases/appcompat))
* Remove `LocalizationApplicationDelegate` from Application class
* Replace `LocalizationActivity` with `AppCompatActivity` or remove `LocalizationActivityDelegate` from your custom Activity
* Replace `setLanguage(language)` with `AppCompatDelegate.setApplicationLocales()`
```kotlin
val locales = LocaleListCompat.forLanguageTags(language)
AppCompatDelegate.setApplicationLocales(locales)
```
* Remove `toLocalizedContext()` and use original Context
* Remove `LocalizationServiceDelegate` from Service class
* Add `androidx.appcompat.app.AppLocalesMetadataHolderService` as `<service>` in Android Manifest (see [Support Android 12 and lower](https://developer.android.com/about/versions/13/features/app-languages#android12-impl))
```xml
<manifest>
  <application>
    <!-- ... -->
    <service 
      android:name="androidx.appcompat.app.AppLocalesMetadataHolderService"
      android:enabled="false"
      android:exported="false">
      <meta-data
        android:name="autoStoreLocales"
        android:value="true" />
    </service>
  </application>
</manifest>
```
* Remove this library from your project (`implementation 'com.akexorcist:localization:<version>'`)
* Test your app

For more information about per-app language preferences, see [Per-app language preferences](https://developer.android.com/about/versions/13/features/app-languages) 
