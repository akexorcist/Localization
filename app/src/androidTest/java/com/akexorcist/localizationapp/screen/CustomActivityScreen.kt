package com.akexorcist.localizationapp.screen

import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import com.akexorcist.localizationapp.R

class CustomActivityScreen : Screen<CustomActivityScreen>() {
    val buttonAmerican = KButton { withId(R.id.btn_america) }
    val buttonChinese = KButton { withId(R.id.btn_china) }
    val buttonItalian = KButton { withId(R.id.btn_italy) }
    val buttonJapanese = KButton { withId(R.id.btn_japan) }
    val buttonKorean = KButton { withId(R.id.btn_korea) }
    val buttonPortuguese = KButton { withId(R.id.btn_portugal) }
    val buttonThai = KButton { withId(R.id.btn_thai) }
    val textViewContent = KTextView { withId(R.id.text_view_content) }
}
