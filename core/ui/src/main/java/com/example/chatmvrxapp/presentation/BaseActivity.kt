package com.example.chatmvrxapp.presentation

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import com.example.chatmvrxapp.di.AssistedViewModelFactory
import com.example.chatmvrxapp.di.ViewModelDependencies

abstract class BaseActivity : AppCompatActivity {

    constructor() : super()

    constructor(@LayoutRes layoutRes: Int) : super(layoutRes)

    lateinit var viewModelFactories: Map<Class<out BaseViewModel<*>>, AssistedViewModelFactory<*, *>>

    final override fun onCreate(savedInstanceState: Bundle?) {
        viewModelFactories = injectDependencies().viewModelFactories()
        super.onCreate(savedInstanceState)
    }

    protected abstract fun injectDependencies(): ViewModelDependencies
}