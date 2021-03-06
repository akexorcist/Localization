package com.akexorcist.localizationapp.screen

import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import com.akexorcist.localizationapp.R

class StackedHomeScreen : Screen<StackedHomeScreen>() {
    val buttonChangeLanguage = KButton { withId(R.id.btn_change_language) }
    val textViewContent = KTextView { withId(R.id.text_view_content) }
}
