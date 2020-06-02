package com.example.chatmvrxapp

import android.content.Context
import com.example.chatmvrxapp.feature.chat.presentation.ChatActivity
import com.example.chatmvrxapp.router.Router
import javax.inject.Inject

class RouterImpl @Inject constructor() : Router {

    override fun toChat(from: Context) {
        ChatActivity.launch(from)
    }
}