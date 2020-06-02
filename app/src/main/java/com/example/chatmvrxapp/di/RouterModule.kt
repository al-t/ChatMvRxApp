package com.example.chatmvrxapp.di

import com.example.chatmvrxapp.RouterImpl
import com.example.chatmvrxapp.router.Router
import dagger.Binds
import dagger.Module

@Module
interface RouterModule {

    @Binds
    fun router(impl: RouterImpl): Router
}
