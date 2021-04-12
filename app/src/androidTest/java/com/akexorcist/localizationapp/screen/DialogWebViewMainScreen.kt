package com.akexorcist.localizationapp.screen

import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import com.akexorcist.localizationapp.R

class DialogWebViewMainScreen : Screen<DialogWebViewMainScreen>() {
    val buttonBack = KButton { withId(R.id.btn_back) }
    val buttonShowWebsite = KButton { withId(R.id.btn_show_website) }
    val buttonChangeLanguage = KButton { withId(R.id.btn_change_language) }
}
