package com.example.chatmvrxapp.presentation

import com.airbnb.mvrx.BaseMvRxViewModel
import com.airbnb.mvrx.BuildConfig
import com.airbnb.mvrx.MvRxState

/**
 * Base class for ViewModels.
 *
 * This class sets the 'Debug' mode in a [BaseMvRxViewModel] to the corresponding parameter
 * in the [BuildConfig] class.
 */
abstract class BaseViewModel<S : MvRxState>(initialState: S) :
    BaseMvRxViewModel<S>(initialState, BuildConfig.DEBUG)