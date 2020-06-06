package com.example.chatmvrxapp.feature.chat.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.chatmvrxapp.chat.R
import com.example.chatmvrxapp.feature.chat.di.ChatComponent

class ChatActivity : AppCompatActivity(R.layout.activity_chat) {

    companion object {

        fun launch(from: Context) {
            from.startActivity(
                Intent(from, ChatActivity::class.java)
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        ChatComponent.initAndGet(this).inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        if (isFinishing) ChatComponent.release(this)
        super.onDestroy()
    }

}
