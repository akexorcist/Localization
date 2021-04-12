package com.akexorcist.localizationapp.screen

import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import com.agoda.kakao.web.KWebView
import com.akexorcist.localizationapp.R

class DialogWebViewSiteScreen : Screen<DialogWebViewSiteScreen>() {
    val buttonBack = KButton { withId(R.id.btn_back) }
    val webViewContent = KWebView { withId(R.id.wv_content) }
}
