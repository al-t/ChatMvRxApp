package com.example.chatmvrxapp.di

import com.example.chatmvrxapp.App
import com.example.chatmvrxapp.DeepLinkActivity
import com.example.chatmvrxapp.feature.chat.di.ChatModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ChatModule::class,
        RouterModule::class
    ]
)
interface AppComponent :
    ViewModelDependencies {

    companion object {

        fun initAndGet(): AppComponent =
            DaggerAppComponent
                .factory()
                .create()
    }

    fun inject(application: App)

    fun inject(activity: DeepLinkActivity)

    @Component.Factory
    interface Factory {

        fun create(): AppComponent
    }
}