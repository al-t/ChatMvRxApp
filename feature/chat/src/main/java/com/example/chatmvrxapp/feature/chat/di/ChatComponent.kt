package com.example.chatmvrxapp.feature.chat.di

import com.example.chatmvrxapp.di.ViewModelDependencies
import com.example.chatmvrxapp.presentation.BaseActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ChatModule::class, ViewModelDependencies::class]
)
abstract class ChatComponent : ViewModelDependencies {

    companion object {

        @JvmStatic
        fun initAndGet(): ChatComponent =
            DaggerChatComponent
                .factory()
                .create()
    }

    abstract fun inject(activity: BaseActivity)

    @Component.Factory
    interface Factory {

        fun create(): ChatComponent

    }
}