package com.example.chatmvrxapp.feature.chat.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.chatmvrxapp.chat.R
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import org.koin.dsl.module

class ChatActivity : AppCompatActivity(R.layout.activity_chat) {

    companion object {

        fun launch(from: Context) {
            from.startActivity(
                Intent(from, ChatActivity::class.java)
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadKoinModules(chatModule)
    }

    override fun onDestroy() {
        unloadKoinModules(chatModule)
        super.onDestroy()
    }
}

private val chatModule = module {

    // зависимости, специфичные для фичи чата

}
