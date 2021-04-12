package com.akexorcist.localizationapp.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.akexorcist.localizationactivity.core.toLocalizedContext
import com.akexorcist.localizationapp.R

class SimpleBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val localizedContext = context.toLocalizedContext()
        val content = localizedContext.getString(R.string.sample_apple_story)
        val broadcastIntent = Intent(BroadcastEvent.ACTION_TO_ACTIVITY).apply {
            `package` = context.packageName
            putExtra(BroadcastEvent.EXTRA_CONTENT, content)
        }
        context.sendBroadcast(broadcastIntent)
    }
}
