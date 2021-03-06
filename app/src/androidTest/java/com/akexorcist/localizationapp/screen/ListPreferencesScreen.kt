package com.akexorcist.localizationapp.screen

import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import com.akexorcist.localizationapp.R

class ListPreferencesScreen : Screen<ListPreferencesScreen>() {
    val buttonChangeLanguage = KButton { withText(R.string.change_language) }
    val buttonAmerican = KButton { withText(R.string.american) }
    val buttonChinese = KButton { withText(R.string.chinese) }
    val buttonItalian = KButton { withText(R.string.italian) }
    val buttonJapanese = KButton { withText(R.string.japanese) }
    val buttonKorean = KButton { withText(R.string.korean) }
    val buttonPortuguese = KButton { withText(R.string.portuguese) }
    val buttonThai = KButton { withText(R.string.thai) }
    val textViewTitle: KTextView
        get() = KTextView {
            withId(android.R.id.title)
            withIndex(0) {}
        }
}
