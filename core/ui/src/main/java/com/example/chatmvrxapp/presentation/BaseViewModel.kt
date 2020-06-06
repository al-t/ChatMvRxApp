package com.example.chatmvrxapp.presentation

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.MvRxState
import com.example.chatmvrxapp.ui.BuildConfig

/**
 * Базовая Вьюмодель.
 * Устанавливает debug mode в [BaseMvRxViewModel] в соответствии с [BuildConfig.DEBUG]
 *
 * @param initialState начальное состояние
 */
abstract class BaseViewModel<S : MvRxState>(initialState: S) :
    BaseMvRxViewModel<S>(initialState, BuildConfig.DEBUG)