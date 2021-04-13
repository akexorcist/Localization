Release Notes
====

1.2.9
-- 
* [Bug] Bug fixed [#93](https://github.com/akexorcist/Localization/issues/93) [#95](https://github.com/akexorcist/Localization/issues/95)
* [PR] [#101](https://github.com/akexorcist/Localization/pull/101) - Update README.md
* Add LocalizationService and LocalizationServiceDelegate for Service
* Add `Context.toLocalizedContext()` extension function to convert context to localized context
* Add more sample code and UI test for Dialog Fragment, Dialog + WebView, and BroadcastReceiver 
* Update Gradle and dependencies version
  * Kotlin : 1.4.32
  * Gradle Plugin : 4.1.3
  * Activity KTX : 1.2.2

1.2.8
----
* [PR] [#96](https://github.com/akexorcist/Localization/issues/96) - Fix compatibility with Hilt ViewModel injection
* Add CI with GitHub Actions

1.2.7
----
* [PR] [#74](https://github.com/akexorcist/Localization/pull/74) - Add setLanguageWithoutNotification
* [PR] [#83](https://github.com/akexorcist/Localization/pull/83) - fix: activity Intent can be NULL
* [Bug] Bug fixed [#72](https://github.com/akexorcist/Localization/issues/72) [#75](https://github.com/akexorcist/Localization/issues/75)
* Migrate sample project from Java to Kotlin
* New UI for sample project
* Add more sample code for Dark Theme and Hilt Dependency Injection 
* Migrate UI test from Espresso to Kakao
* Update Gradle and dependencies version
  * Kotlin : 1.4.31
  * Gradle Plugin : 4.1.2
  * Gradle Wrapper : 6.5

1.2.6
----
* [PR] [#66](https://github.com/akexorcist/Android-Localization/issues/66) - Fix incompatible with AppCompat 1.2.0 or higher
* [PR] [#60](https://github.com/akexorcist/Android-Localization/issues/60) - Supporting locale variants
* [Bug] Bug fixed [#65](https://github.com/akexorcist/Android-Localization/issues/65)
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
* [Bug] Bug fixed [#53](https://github.com/akexorcist/Android-Localization/issues/53) [#52](https://github.com/akexorcist/Android-Localization/issues/52) [#41](https://github.com/akexorcist/Android-Localization/issues/41)
* Removed dummy activity for fade in/out transition when language changing (if you want, create by yourself when onBeforeLocaleChanged(...) called)
* API level 14 supported ([#54](https://github.com/akexorcist/Android-Localization/issues/54))
* Added example code for AndroidX Preferences 

1.2.4
----
* Merged PR from [#7](https://github.com/akexorcist/Android-Localization/pull/7) [#25](https://github.com/akexorcist/Android-Localization/pull/25) [#10](https://github.com/akexorcist/Android-Localization/pull/10)
 
1.2.3
----
* [Bug] Bug fixed : Incorrect behavior in API level 24-27 (Android 7.0 - 8.1) [#30](https://github.com/akexorcist/Android-Localization/issues/30) [#37](https://github.com/akexorcist/Android-Localization/issues/37)
* [Bug] Bug fixed : setDefaultLanguage does not work properly [#28](https://github.com/akexorcist/Android-Localization/issues/28)
* Migrate to AndroidX and latest Gradle
* Migrate to Kotlin
* Add UI automated test in example code
* Move set default language to Application class (Please see the migrate instruction)
* Add pre-implemented application class for LocalizationApplicationDelegate

1.2.2
----
* [Bug] Bug fixed [#18](https://github.com/akexorcist/Android-Localization/issues/18) 
* Remove java 1.8 and lambda from the library 
* Update gradle to 3.0 stable

1.2.1
----
* Support string resource from getApplicationContext() 
* Add LocalizationApplicationDelegate. So you need to custom application class in your app
* LocalizationDelegate was deprecated, replace by LocalizationActivityDelegate 

1.2.0
----
* [Bug] Bug fixed : Android 7.0 language [#14](https://github.com/akexorcist/Android-Localization/issues/14)
* [Bug] Language and country support [#5](https://github.com/akexorcist/Android-Localization/issues/5)
* [Bug] RTL on orientation changes [#15](https://github.com/akexorcist/Android-Localization/issues/15) [#9](https://github.com/akexorcist/Android-Localization/issues/9)