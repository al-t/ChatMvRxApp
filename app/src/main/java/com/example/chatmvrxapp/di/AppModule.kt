package com.example.chatmvrxapp.di

import com.example.chatmvrxapp.ui.ChatViewModel
import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@AssistedModule
@Module(includes = [AssistedInject_AppModule::class])
interface AppModule {

    @Binds
    @IntoMap
    @ViewModelKey(ChatViewModel::class)
    fun helloViewModelFactory(factory: ChatViewModel.Factory): AssistedViewModelFactory<*, *>
}