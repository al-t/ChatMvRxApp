package com.example.chatmvrx.di.dependency

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ComponentDependenciesModule {

    @Provides
    @Singleton
    fun provideComponentDependenciesHolder(): ComponentDependenciesHolder =
        ComponentDependenciesHolder()
}