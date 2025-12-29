package com.github.broadcastrecivier

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class BootCompleteReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        Log.e("BootCompleteReceiver", "===== BOOT COMPLETED RECEIVED =====")
        Log.d("BootCompleteReceiver", "Action: ${intent?.action}")
        Log.d("BootCompleteReceiver", "Timestamp: ${System.currentTimeMillis()}")
        Log.e("BootCompleteReceiver", "===== END =====")
    }
}