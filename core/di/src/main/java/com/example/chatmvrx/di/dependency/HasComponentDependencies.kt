package com.example.chatmvrx.di.dependency

import android.app.Application

/**
 * Интерфейс предназначеный обеспечивать работу [ComponentDependenciesHolder]
 *
 * Данный интерфейс должен реализовывать [Application]
 */
interface HasComponentDependencies<AppComponent> {

    val componentDependenciesHolder: ComponentDependenciesHolder

    val appComponent: AppComponent
}