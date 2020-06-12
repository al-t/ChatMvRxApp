package com.example.chatmvrxapp

import android.app.Application
import com.example.chatmvrxapp.router.Router
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(routerModule)
        }
    }

}

private val routerModule = module {

    factory<Router> { RouterImpl() }

}