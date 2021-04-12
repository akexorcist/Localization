package com.akexorcist.localizationapp.dialogwebview

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import com.akexorcist.localizationactivity.ui.LocalizationActivity
import com.akexorcist.localizationapp.R
import com.akexorcist.localizationapp.databinding.ActivityDialogWebviewSiteBinding

class DialogWebViewSiteActivity : LocalizationActivity() {
    private val binding: ActivityDialogWebviewSiteBinding by lazy { ActivityDialogWebviewSiteBinding.inflate(layoutInflater) }

    @SuppressLint("SetJavaScriptEnabled")
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.btnBack.setOnClickListener { super.onBackPressed() }
        binding.wvContent.run {
            settings.javaScriptEnabled = true
            setBackgroundColor(Color.TRANSPARENT)
            loadData(htmlData, "text/html", "UTF-8")
        }
    }

    private val htmlData: String
        get() = """
            <html>
                <head>
                    <style type="text/css">
                        p {
                            color: white;
                        }
                    </style>
                </head>
                <body>
                    <p id="content">
                        ${getString(R.string.hello_world)}
                    </p>
                </body>
            </html>
            """.trimIndent()
}
