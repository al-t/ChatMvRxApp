package com.example.chatmvrx.di.dependency

import android.app.Application

/**
 * Интерфейс предназначеный обеспечивать работу [ComponentDependenciesHolder]
 *
 * Данный интерфейс должен реализовывать [Application]
 *
 * @author Коваль Ростислав
 */
interface HasComponentDependencies<AppComponent> {

    val componentDependenciesHolder: ComponentDependenciesHolder

    val appComponent: AppComponent
}