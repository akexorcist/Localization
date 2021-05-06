package com.akexorcist.localizationapp.broadcast

object BroadcastEvent {
    // Activity -> Broadcast Receiver
    const val ACTION_TO_BROADCAST = "com.akexorcist.localizationapp.receiver.action.TO_BROADCAST"

    // Broadcast Receiver -> Activity
    const val ACTION_TO_ACTIVITY = "com.akexorcist.localizationapp.receiver.action.TO_ACTIVITY"
    const val EXTRA_CONTENT = "com.akexorcist.localizationapp.receiver.extra.CONTENT"
}
