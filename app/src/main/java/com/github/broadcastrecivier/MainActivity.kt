package com.github.broadcastrecivier

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    private lateinit var tickReceiver: BroadcastReceiver
    override fun onCreate(savedInstanceState: Bundle?) {


        Log.e("BootCompleteReceiver", "===== APP STARTED =====")
        super.onCreate(savedInstanceState)

        tickReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                Log.e("TickReceiver", "===== TIME TICK RECEIVED =====")
                Log.d("TickReceiver", "Current time: ${System.currentTimeMillis()}")
                Log.e("TickReceiver", "===== END =====")
            }
        }
        val filter = IntentFilter(Intent.ACTION_TIME_TICK)

        registerReceiver(tickReceiver, filter)


        Log.e("MainActivity", "Receiver registered!")

        setContent {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Boot Receiver App Installed\nRestart your device to see logs",
                    fontSize = 16.sp
                )
            }
        }
    }
}