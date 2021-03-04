[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Android--Localization-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/2890)
[![JCenter](https://api.bintray.com/packages/akexorcist/maven/localization/images/download.svg)](https://bintray.com/akexorcist/maven/localization) 
![Minimum SDK Version](https://img.shields.io/badge/minSdkVersion-14-brightgreen) 
[![Build Status](https://travis-ci.org/akexorcist/Android-Localization.svg?branch=master)](https://travis-ci.org/akexorcist/Android-Localization) 


Localization Library
====
![Header image](https://raw.githubusercontent.com/akexorcist/Android-Localization/master/image/01-header.jpg)
Android library for in-app language changes support in your application 


Feature
====
* In-app language changing
* Default language when first launch
* Work with string resource in XML and programmatically
* RTL language support
* Align on platform behavior


Demo
====
Try it at [Google Play](https://play.google.com/store/apps/details?id=com.akexorcist.localizationapp)


Download
====
Gradle
```groovy
implementation 'com.akexorcist:localization:1.2.6'
```

(Optional) You can exclude `androidx.appcompat:appcompat`, if your project does not use AppCompat.
```groovy
implementation ('com.akexorcist:localization:1.2.6') {
    exclude group: 'androidx.core', module: 'core'
}
```


Usage
====
Custom application class which extends from `LocalizationApplication` is require.
```kotlin
class MainApplication: LocalizationApplication() {
    /* ... */
    override fun getDefaultLanguage() = Locale.ENGLISH
}
```

Either not, using `LocalizationApplicationDelegate` with additional code as below
```kotlin
class MainApplication: Application() {
    private val localizationDelegate = LocalizationApplicationDelegate()

    override fun attachBaseContext(base: Context) {
        localizationDelegate.setDefaultLanguage(base, Locale.ENGLISH)
        super.attachBaseContext(localizationDelegate.attachBaseContext(base))
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        localizationDelegate.onConfigurationChanged(this)
    }

    override fun getApplicationContext(): Context {
        return localizationDelegate.getApplicationContext(super.getApplicationContext())
    }
}
```

For the activities, extends from `LocalizationActivity`.

```kotlin
class MainActivity: LocalizationActivity() {
    /* ... */
}
``` 

Or using `LocalizationActivityDelegate` with additional code
```kotlin
open class CustomActivity : Activity(), OnLocaleChangedListener {
    private val localizationDelegate = LocalizationActivityDelegate(this)

    public override fun onCreate(savedInstanceState: Bundle?) {
        localizationDelegate.addOnLocaleChangedListener(this)
        localizationDelegate.onCreate()
        super.onCreate(savedInstanceState)
    }

    public override fun onResume() {
        super.onResume()
        localizationDelegate.onResume(this)
    }

    override fun attachBaseContext(newBase: Context) {
        applyOverrideConfiguration(localizationDelegate.updateConfigurationLocale(newBase))
        super.attachBaseContext(newBase)
    }

    override fun getApplicationContext(): Context {
        return localizationDelegate.getApplicationContext(super.getApplicationContext())
    }

    override fun getResources(): Resources {
        return localizationDelegate.getResources(super.getResources())
    }

    fun setLanguage(language: String?) {
        localizationDelegate.setLanguage(this, language!!)
    }

    fun setLanguage(locale: Locale?) {
        localizationDelegate.setLanguage(this, locale!!)
    }

    val getCurrentLanguage: Locale = localizationDelegate.getLanguage(this)

    // Just override method locale change event
    override fun onBeforeLocaleChanged() {}
    override fun onAfterLocaleChanged() {}
}
```

Then prepare your multilingual content in string resource. 

![Multilingual Content](https://raw.githubusercontent.com/akexorcist/Android-Localization/master/image/02-string_resource.jpg)


Public method on LocalizationActivity
----

It have only 4 public methods.

```kotlin
fun setLanguage(language: String)
fun setLanguage(language: String, country: Strinng)
fun setLanguage(locale: Locale)
fun getCurrentLanguage(): String
```

`setLanguage` Set the language that you need to change.

For example

```kotlin
setLanguage("th")                             // Language : Thailand
setLanguage("th", "TH")                       // Language : Thailand, Country : Thai
setLanguage(Locale("th", "TH"))               // Language : Thailand, Country : Thai
setLanguage("en")                             // Language : English
setLanguage("en", "GB")                       // Language : English,  Country : Great Britain
setLanguage("en", "US")                       // Language : English,  Country : United States
setLanguage(Locale("en", "US"))               // Language : English,  Country : United States
setLanguage(Locale.KOREA)                     // Language : Korean,   Country : Korea
setLanguage(Locale.KOREAN)                    // Language : Korean
setLanguage(Locale.CANADA_FRENCH)             // Language : French,   Country : Canada
```

`getLanguage` Get current language as string locale. 

And 2 optional override methods.

```kotlin
fun onBeforeLocaleChanged()
fun onAfterLocaleChanged()
```

This override method will be useful when you need to know when language has changed.

![Back Stack 1](https://raw.githubusercontent.com/akexorcist/Android-Localization/master/image/04-life_cycle.jpg)

When `setLanguage` was called. Current active activity will be recreated to apply the new language.

![Back Stack 2](https://raw.githubusercontent.com/akexorcist/Android-Localization/master/image/05-step_one.jpg)

Previous activities in back stack does not change to new language immediately. Until it back to active activity again.

![Back Stack 3](https://raw.githubusercontent.com/akexorcist/Android-Localization/master/image/06-step_two.jpg)
 
![Back Stack 4](https://raw.githubusercontent.com/akexorcist/Android-Localization/master/image/07-step_three.jpg)

![Back Stack 5](https://raw.githubusercontent.com/akexorcist/Android-Localization/master/image/08-step_four.jpg)


Action Bar or Toolbar's title
----
You have to call `setTitle(resId)` or `getActionBar().setTitle(resId)` in `onCreate(onSavedInstanceState: Bundle)` to apply the new language.

```kotlin
class MainActivity: LocalizationActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        /* ... */
        setTitle(R.string.main_activity_title)
    }
}
 ```


Handle state changes
----
Activity will be recreate when language has changed as common behavior for configuration changes in Android. Any Activities or Fragments which hold the data should handle the state changes.


Change the language in Fragment
----
Language in fragment will depends on activity. So no need for additional code in Fragment.


Language resources optimization in Android App Bundle
====
Change the language by library can cause a crash to your app when you publishing your app with Android App Bundle with language resources optimization enabled. 

To fix this, Using the Additional Languages API in Play Core library to download the additional language before.

For more information about Additional Language API : https://android-developers.googleblog.com/2019/03/the-latest-android-app-bundle-updates.html 

If you don't want to implement this feature in your code, just ignore the language resources optimization by adding the Android App Bundle configuration in your app's build.gradle
```groovy
android {
    /* ... */ 
    bundle { 
        language { 
            enableSplit = false 
        } 
    } 
}
```  

ProGuard
=====
Normally, there's no require the ProGuard rules for this library. 

But if you want to exclude this library from obfuscate and shrinking. You also can add these code to `proguard-rules.pro` 
```  
-keep class com.akexorcist.localizationactivity.** { *; }
-dontwarn com.akexorcist.localizationactivity.**
```


Change Log
====
See [CHANGELOG.md](CHANGELOG.md)


Licence
====
Copyright 2021 Akexorcist

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this work except in compliance with the License. You may obtain a copy of the License in the LICENSE file, or at:

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
