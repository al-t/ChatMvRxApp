package com.example.chatmvrxapp.di

import com.example.chatmvrxapp.presentation.BaseViewModel
import dagger.Module

@Module
interface ViewModelDependencies {

    fun viewModelFactories(): Map<Class<out BaseViewModel<*>>, AssistedViewModelFactory<*, *>>
}
