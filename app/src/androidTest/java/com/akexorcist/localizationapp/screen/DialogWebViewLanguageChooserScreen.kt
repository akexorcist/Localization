package com.akexorcist.localizationapp.screen

import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import com.akexorcist.localizationapp.R

class DialogWebViewLanguageChooserScreen : Screen<DialogWebViewLanguageChooserScreen>() {
    val buttonAmerican = KButton { withId(R.id.btn_american) }
    val buttonChinese = KButton { withId(R.id.btn_chinese) }
    val buttonItalian = KButton { withId(R.id.btn_italian) }
    val buttonJapanese = KButton { withId(R.id.btn_japanese) }
    val buttonKorean = KButton { withId(R.id.btn_korean) }
    val buttonPortuguese = KButton { withId(R.id.btn_portuguese) }
    val buttonThai = KButton { withId(R.id.btn_thai) }
}
