package com.example.chatmvrxapp

import android.app.Application
import com.example.chatmvrx.di.dependency.ComponentDependenciesHolder
import com.example.chatmvrx.di.dependency.HasComponentDependencies
import com.example.chatmvrxapp.di.AppComponent

class App : Application(), HasComponentDependencies<AppComponent> {

    override val componentDependenciesHolder = ComponentDependenciesHolder()

    override lateinit var appComponent: AppComponent

    override fun onCreate() {
        appComponent = AppComponent.initAndGet()
        appComponent.inject(this)
        super.onCreate()
    }
}
