package com.example.chatmvrxapp.feature.chat.di

import android.content.Context
import com.example.chatmvrx.di.dependency.CacheableComponentDependencies
import com.example.chatmvrx.di.dependency.ComponentDependenciesHolder
import com.example.chatmvrxapp.feature.chat.presentation.ChatActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [ChatModule::class]
)
interface ChatComponent : CacheableComponentDependencies {

    companion object {

        fun initAndGet(context: Context): ChatComponent =
            ComponentDependenciesHolder.getInstance(context.applicationContext)
                .getCacheableComponent(ChatComponent::class.java) {
                    DaggerChatComponent
                        .factory()
                        .create()
                }

        fun release(context: Context) = ComponentDependenciesHolder
            .getInstance(context.applicationContext)
            .releaseCachableComponent(ChatComponent::class.java)
    }

    fun inject(activity: ChatActivity)

    @Component.Factory
    interface Factory {

        fun create(): ChatComponent

    }
}