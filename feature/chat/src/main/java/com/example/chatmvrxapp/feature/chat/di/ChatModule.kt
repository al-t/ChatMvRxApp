package com.example.chatmvrxapp.feature.chat.di

import com.example.chatmvrxapp.di.AssistedViewModelFactory
import com.example.chatmvrxapp.di.ViewModelKey
import com.example.chatmvrxapp.feature.chat.presentation.ChatViewModel
import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@AssistedModule
@Module(includes = [AssistedInject_ChatModule::class])
interface ChatModule {

    @Binds
    @IntoMap
    @ViewModelKey(ChatViewModel::class)
    fun chatViewModelFactory(factory: ChatViewModel.Factory): AssistedViewModelFactory<*, *>
}