package com.akexorcist.localizationactivity.core

import android.content.Context
import android.os.Build
import android.webkit.WebView

object WebViewResourceSolver {
    private var isSolved = false

    fun execute(context: Context) {
        if (!isSolved && Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            WebView(context).destroy()
        }
        isSolved = true
    }
}