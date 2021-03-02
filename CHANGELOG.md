Release Notes
====

1.2.6
----
* [pr] [#66](https://github.com/akexorcist/Android-Localization/issues/66) - Fix incompatible with AppCompat 1.2.0 or higher
* [pr] [#60](https://github.com/akexorcist/Android-Localization/issues/60) - Supporting locale variants
* [bug] Bug fixed [#65](https://github.com/akexorcist/Android-Localization/issues/65)
* Add layout resource support in LocalizationActivity's constructor 
* Fix base context and application context not update in some version
* Update UI test
* Update Gradle and dependencies version
  * Kotlin : 1.3.72
  * Gradle Plugin : 4.0.1
  * Gradle Wrapper : 6.1.1 
  * AppCompat : 1.2.0 

1.2.5
----
* [bug] Bug fixed [#53](https://github.com/akexorcist/Android-Localization/issues/53) [#52](https://github.com/akexorcist/Android-Localization/issues/52) [#41](https://github.com/akexorcist/Android-Localization/issues/41)
* Removed dummy activity for fade in/out transition when language changing (if you want, create by yourself when onBeforeLocaleChanged(...) called)
* API level 14 supported ([#54](https://github.com/akexorcist/Android-Localization/issues/54))
* Added example code for AndroidX Preferences 

1.2.4
----
* Merged PR from [#7](https://github.com/akexorcist/Android-Localization/pull/7) [#25](https://github.com/akexorcist/Android-Localization/pull/25) [#10](https://github.com/akexorcist/Android-Localization/pull/10)
 
1.2.3
----
* [bug] Bug fixed : Incorrect behavior in API level 24-27 (Android 7.0 - 8.1) [#30](https://github.com/akexorcist/Android-Localization/issues/30) [#37](https://github.com/akexorcist/Android-Localization/issues/37)
* [bug] Bug fixed : setDefaultLanguage does not work properly [#28](https://github.com/akexorcist/Android-Localization/issues/28)
* Migrate to AndroidX and latest Gradle
* Migrate to Kotlin
* Add UI automated test in example code
* Move set default language to Application class (Please see the migrate instruction)
* Add pre-implemented application class for LocalizationApplicationDelegate

1.2.2
----
* [bug] Bug fixed [#18](https://github.com/akexorcist/Android-Localization/issues/18) 
* Remove java 1.8 and lambda from the library 
* Update gradle to 3.0 stable

1.2.1
----
* Support string resource from getApplicationContext() 
* Add LocalizationApplicationDelegate. So you need to custom application class in your app
* LocalizationDelegate was deprecated, replace by LocalizationActivityDelegate 

1.2.0
----
* [bug] Bug fixed : Android 7.0 language [#14](https://github.com/akexorcist/Android-Localization/issues/14)
* [bug] Language and country support [#5](https://github.com/akexorcist/Android-Localization/issues/5)
* [bug] RTL on orientation changes [#15](https://github.com/akexorcist/Android-Localization/issues/15) [#9](https://github.com/akexorcist/Android-Localization/issues/9)