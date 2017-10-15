
[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Android--LocalizationActivity-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/2890) [![Build Status](https://travis-ci.org/akexorcist/Android-LocalizationActivity.svg?branch=master)](https://travis-ci.org/akexorcist/Android-LocalizationActivity) [![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.akexorcist/localizationactivity/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.akexorcist/localizationactivity)

Android-LocalizationActivity
==============================

![Header image](https://raw.githubusercontent.com/akexorcist/Android-LocalizationActivity/master/image/01-header.jpg)

Keep calm and stay easy with multiple language supported in your android application.

It's basic for android application to be supported multiple languages. Yeah! It's very easy because android has String Resource. Developer just had to prepare the text for different languages then android system will use itself.
But frequently problem is "On-time Language Changing". Because the String Resource was designed to be depending on current device language. but if we want to change the language by click some button. It will be difficult to handle it.
This problem will solved because I have created a new library to handle application language. It called "Localization Activity" library.


Demo
===============================

Watch a short demo video from [YouTube](https://www.youtube.com/watch?v=mFtVIFr2taY) or try it at [Google Play](https://play.google.com/store/apps/details?id=com.akexorcist.localizationapp)


Download
===============================

Maven
```
<dependency>
  <groupId>com.akexorcist</groupId>
  <artifactId>localizationactivity</artifactId>
  <version>1.2.0</version>
</dependency>
```

Gradle
```
compile 'com.akexorcist:localizationactivity:1.2.0'
```

(Optional) You can exclude `com.android.support:appcompat-v7`, if your project doens't use AppCompat v7 and declare this library with delegate way.

Update 1.2.0
===========================
* [bug] Bug fixed : Android 7.0 language #14
* [bug] Language and country support #5
* [bug] RTL on orientation changes #15 #9



Feature
===========================
* On-time language changing supported.
* Auto setup when activity was created.
* Current language config will saved to SharedPreference automatically.
* Very easy to use it.


LocalizationActivity extends from AppCompatActivity
===========================
LocalizationActivity is extend from AppCompatActivity class. So you still can use all method from AppCompatActivity class.

![Header image](https://raw.githubusercontent.com/akexorcist/Android-LocalizationActivity/master/image/03-extend.jpg)


Don't like AppCompat v7? Try delegate way 
===========================
(By @AleksanderMielczarek)
```java
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.akexorcist.localizationactivity.LocalizationDelegate;
import com.akexorcist.localizationactivity.OnLocaleChangedListener;

import java.util.Locale;

/**
 * Created by Akexorcist on 6/23/16 AD.
 */
public abstract class CustomActivity extends Activity implements OnLocaleChangedListener {

    private LocalizationDelegate localizationDelegate = new LocalizationDelegate(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        localizationDelegate.addOnLocaleChangedListener(this);
        localizationDelegate.onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        localizationDelegate.onResume();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(localizationDelegate.attachBaseContext(newBase));
    }

    public final void setLanguage(String language) {
        localizationDelegate.setLanguage(language);
    }

    public final void setLanguage(String language, String country) {
        localizationDelegate.setLanguage(language, country);
    }

    public final void setLanguage(Locale locale) {
        localizationDelegate.setLanguage(locale);
    }

    public final void setDefaultLanguage(String language) {
        localizationDelegate.setDefaultLanguage(language);
    }

    public final void setDefaultLanguage(String language, String country) {
        localizationDelegate.setDefaultLanguage(language, country);
    }

    public final void setDefaultLanguage(Locale locale) {
        localizationDelegate.setDefaultLanguage(locale);
    }

    public final Locale getLanguage() {
        return localizationDelegate.getLanguage();
    }

    @Override
    public void onBeforeLocaleChanged() {
    }

    @Override
    public void onAfterLocaleChanged() {
    }
}
```


Usage
===========================
This is an example.

```java
import android.os.Bundle;
import android.view.View;

import com.akexorcist.localizationactivity.LocalizationActivity;

public class MainActivity extends LocalizationActivity implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);

        findViewById(R.id.btn_th).setOnClickListener(this);
        findViewById(R.id.btn_en).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_en) {
            setLanguage("en");
        } else if (id == R.id.btn_th) {
            setLanguage("th");
        }
    }
}
```

In the example above, when user click on a button. It will change to English or Thai language. That's It! Localization Activity Library example.

**It's very easy, right?** You barely have to do anything.

Then just build up some String Resource for English and Thai language.

![Header image](https://raw.githubusercontent.com/akexorcist/Android-LocalizationActivity/master/image/02-string_resource.jpg)

Complete! Your application support with multiple language now.


Public method on LocalizationActivity
---------------------------

I wanted it to be easy to use and does not have to do much coding. So it have only 3 public methods.

```java
void setLanguage(String language)
void setLanguage(String language, String country)
void setLanguage(Locale locale)
String getLanguage()
void setDefaultLanguage(String language)
void setDefaultLanguage(String language, String country)
void setDefaultLanguage(Locale locale)
```

**setLanguage** Set the language that you needs to change. The string value given will be use for setup Locale class later.

Example

```java
setLanguage("th")                             // Language : Thailand
setLanguage("th", "TH")                       // Language : Thailand, Country : Thai
setLanguage("en")                             // Language : English
setLanguage("en", "GB")                       // Language : English,  Country : Great Britain
setLanguage("en", "US")                       // Language : English,  Country : United States
setLanguage(Locale.KOREA)                     // Language : Korean,  Country : Korea
setLanguage(Locale.KOREAN)                    // Language : Korean
setLanguage(Locale.CANADA_FRENCH)             // Language : French,  Country : Canada
```

So you must determine the correct language for Locale class.

**getLanguage** Get current language. (Return to string locale)

**setDefaultLanguage** Set default language if there is no language configuration. Provided that this method must called only once at first activity in your application and called before super.onCreate

```java
@Override
public void onCreate(Bundle savedInstanceState) {
    setDefaultLanguage(Locale.JAPAN);
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ...
}
```

and 2 optional override methods.

```java
void onBeforeLocaleChanged()
void onAfterLocaleChanged()
```

This override method will be called then activity language was changed. If you need to know when language has change, just override these methods.

![Header image](https://raw.githubusercontent.com/akexorcist/Android-LocalizationActivity/master/image/04-life_cycle.jpg)

Usually change the language code has a problem with activity that already created.

![Header image](https://raw.githubusercontent.com/akexorcist/Android-LocalizationActivity/master/image/05-step_one.jpg)

If latest activity can change the language. It does not apply to previous activity.

![Header image](https://raw.githubusercontent.com/akexorcist/Android-LocalizationActivity/master/image/06-step_two.jpg)

But no problem for this library when application getback to previous activity. If you extend that activity to LocalizationActivity. It will changed immediately.

![Header image](https://raw.githubusercontent.com/akexorcist/Android-LocalizationActivity/master/image/07-step_three.jpg)

![Header image](https://raw.githubusercontent.com/akexorcist/Android-LocalizationActivity/master/image/08-step_four.jpg)


Action Bar or Toolbar's title
---------------------------
You have to call 
```
setTitle(String title)
// or
getActionBar().setTitle(String title)
 ```
 in on activity create (onCreate) every time
 ```
 public class MainActivity extends Localization {
     @Override
     public void onCreate(Bundle onSavedInstanceState) {
         ...
         setTitle(R.string,user_management_screen);
     }
 }
 ```


Instance State
---------------------------
When language was changed. An activity wil recreated. So if you have any data object. It should be handle by save/restore instance state for complelely works. (It simple way to supported portrait/landscape orientation)

Therefore you have to override onSaveInstance and onRestoreInstance in to your code, and handle it.

```java
import android.os.Bundle;
import android.view.View;

public class MainActivity extends LocalizationActivity implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO Initial view and widget here

        if (savedInstanceState == null) {
            // TODO Activity first created
        } else {
            // TODO Activity recreated from screen orientation or change language
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // TODO Save instance here
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        // TODO Restore instance here
        super.onRestoreInstanceState(savedInstanceState);
    }
}
```


Fragment
---------------------------
It's affect on fragment as well.

Fragment language configuration is depending with activity. If activity language was changed and recreated. It will apply to fragment as well. So you have to handle to Instance State on fragment like an activity.

About Save/Restore Instance State. Read more on The [Real Best Practices to Save/Restore Activity's and Fragment's state.](http://inthecheesefactory.com/blog/fragment-state-saving-best-practices/en)


Documentation
===========================
English Version : http://www.akexorcist.com/2015/07/localization-activity-best-way-to-handle-language-en.html

Thai Version : http://www.akexorcist.com/2015/07/localization-activity-best-way-to-handle-language.html


Special Thanks
===========================
@first087
@AleksanderMielczarek


Licence
===========================
Copyright 2015 Akexorcist

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this work except in compliance with the License. You may obtain a copy of the License in the LICENSE file, or at:

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
