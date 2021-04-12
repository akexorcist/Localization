package com.akexorcist.localizationapp.screen

import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KTextView
import com.akexorcist.localizationapp.R

class SimpleDialogContentScreen : Screen<SimpleDialogContentScreen>() {
    val textViewContent = KTextView { withId(R.id.text_view_content) }
}
