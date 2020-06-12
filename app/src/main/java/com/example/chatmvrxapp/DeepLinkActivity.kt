package com.example.chatmvrxapp

import androidx.appcompat.app.AppCompatActivity
import com.example.chatmvrxapp.router.Router
import org.koin.android.ext.android.inject

class DeepLinkActivity : AppCompatActivity() {

    private val router: Router by inject()

    override fun onStart() {
        super.onStart()
        router.toChat(this)
        finish()
    }
}