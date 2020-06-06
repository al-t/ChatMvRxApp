package com.example.chatmvrxapp.di

import com.example.chatmvrx.di.dependency.ApplicationComponentDependencies
import com.example.chatmvrxapp.presentation.BaseViewModel

interface ViewModelDependencies : ApplicationComponentDependencies {

    fun viewModelFactories(): Map<Class<out BaseViewModel<*>>, AssistedViewModelFactory<*, *>>
}
