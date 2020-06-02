package com.example.chatmvrxapp

import com.example.chatmvrxapp.di.AppComponent
import com.example.chatmvrxapp.di.ViewModelDependencies
import com.example.chatmvrxapp.presentation.BaseActivity
import com.example.chatmvrxapp.router.Router
import javax.inject.Inject

class DeepLinkActivity : BaseActivity() {

    @Inject
    lateinit var router: Router

    override fun onStart() {
        super.onStart()
        router.toChat(this)
        finish()
    }

    override fun injectDependencies(): ViewModelDependencies {
        val component = AppComponent.initAndGet()
        component.inject(this)
        return component
    }
}