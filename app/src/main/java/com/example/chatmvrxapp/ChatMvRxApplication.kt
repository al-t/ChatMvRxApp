package com.example.chatmvrxapp

import android.app.Application
import androidx.fragment.app.FragmentActivity
import com.example.chatmvrxapp.di.AppComponent
import com.example.chatmvrxapp.di.DaggerAppComponent

class ChatMvRxApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}

fun FragmentActivity.appComponent(): AppComponent {
    return (application as ChatMvRxApplication).appComponent
}
