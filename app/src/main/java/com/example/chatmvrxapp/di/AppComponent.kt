package com.example.chatmvrxapp.di

import android.app.Application
import com.example.chatmvrxapp.DeepLinkActivity
import com.example.chatmvrxapp.feature.chat.di.ChatDependencies
import com.example.chatmvrxapp.feature.chat.di.ChatModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ChatModule::class,
        RouterModule::class,
        ViewModelDependencies::class
    ]
)
interface AppComponent :
    ChatDependencies,
    ViewModelDependencies {

    companion object {

        @JvmStatic
        fun initAndGet(): AppComponent =
            DaggerAppComponent
                .factory()
                .create()
    }

    fun inject(application: Application)

    fun inject(activity: DeepLinkActivity)

    @Component.Factory
    interface Factory {

        fun create(): AppComponent
    }
}