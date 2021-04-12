package com.akexorcist.localizationapp.screen

import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import com.akexorcist.localizationapp.R

class SimpleDialogMainScreen : Screen<SimpleDialogMainScreen>() {
    val buttonBack = KButton { withId(R.id.btn_back) }
    val buttonChangeLanguage = KButton { withId(R.id.btn_change_language) }
    val buttonShowContent = KButton { withId(R.id.btn_show_content) }
}
