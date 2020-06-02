package com.example.chatmvrxapp.feature.chat.presentation

import android.content.Context
import android.content.Intent
import com.example.chatmvrxapp.chat.R
import com.example.chatmvrxapp.di.ViewModelDependencies
import com.example.chatmvrxapp.feature.chat.di.ChatComponent
import com.example.chatmvrxapp.presentation.BaseActivity

class ChatActivity : BaseActivity(R.layout.activity_chat) {

    companion object {

        fun launch(from: Context) {
            from.startActivity(
                Intent(from, ChatActivity::class.java)
            )
        }
    }

    override fun injectDependencies(): ViewModelDependencies {
        return ChatComponent.initAndGet()
    }
}
