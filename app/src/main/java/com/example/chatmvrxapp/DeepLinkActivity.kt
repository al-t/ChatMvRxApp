package com.example.chatmvrxapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.chatmvrxapp.di.AppComponent
import com.example.chatmvrxapp.router.Router
import javax.inject.Inject

class DeepLinkActivity : AppCompatActivity() {

    @Inject
    lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        AppComponent.initAndGet().inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        router.toChat(this)
        finish()
    }
}