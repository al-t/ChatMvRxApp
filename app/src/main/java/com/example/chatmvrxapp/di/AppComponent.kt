package com.example.chatmvrxapp.di

import com.example.chatmvrxapp.base.BaseViewModel
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun viewModelFactories(): Map<Class<out BaseViewModel<*>>, AssistedViewModelFactory<*, *>>
}