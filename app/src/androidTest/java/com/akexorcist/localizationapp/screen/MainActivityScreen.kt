package com.akexorcist.localizationapp.screen

import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import com.akexorcist.localizationapp.R

open class MainActivityScreen : Screen<MainActivityScreen>() {
    val textViewTitle = KTextView { withId(R.id.text_view_title) }
    val buttonSimpleActivity = KButton { withId(R.id.btn_simple_activity) }
    val buttonCustomActivity = KButton { withId(R.id.btn_custom_activity) }
    val buttonStackedActivity = KButton { withId(R.id.btn_stacked_activity) }
    val buttonSimpleFragment = KButton { withId(R.id.btn_simple_fragment) }
    val buttonNestedFragment = KButton { withId(R.id.btn_nested_fragment) }
    val buttonSimpleDialog = KButton { withId(R.id.btn_dialog_fragment) }
    val buttonDialogWebView = KButton { withId(R.id.btn_dialog_web_view) }
    val buttonViewPager = KButton { withId(R.id.btn_view_pager) }
    val buttonListPreferences = KButton { withId(R.id.btn_list_preferences) }
    val buttonDarkTheme = KButton { withId(R.id.btn_dark_theme) }
    val buttonHilt = KButton { withId(R.id.btn_hilt) }
    val buttonBroadcastReceiver = KButton { withId(R.id.btn_broadcast_receiver) }
}
