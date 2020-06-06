package com.example.chatmvrxapp.di

import dagger.MapKey
import kotlin.reflect.KClass

/**
 * Ключ [MapKey] для заполнения карты Вьюмоделей и соответствующих им фабрик
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
@MapKey
annotation class ViewModelKey(val value: KClass<out com.example.chatmvrxapp.presentation.BaseViewModel<*>>)
