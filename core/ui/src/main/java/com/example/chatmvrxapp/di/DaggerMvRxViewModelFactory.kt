package com.example.chatmvrxapp.di

import com.airbnb.mvrx.MvRxState
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.example.chatmvrx.di.dependency.ComponentDependenciesHolder
import com.example.chatmvrxapp.presentation.BaseViewModel

/**
 * Фабрика вьюмоделей [MvRxViewModelFactory] для создания инстансов вьюмоделей при использовании
 * AssistedInject. Этот класс должен быть реализован в companion object каждой вьмодели, которая
 * использует AssistedInject (то есть, в которую нужно инжектить какие-то зависимости).
 *
 * @param viewModelClass класс вьюмодели
 *
 * Этот класс достаёт нужную фабрику [AssistedViewModelFactory] из карты фабрик, сгенерённой
 * Даггером.
 * Затем он создаёт инстанс вьмодели с помощью этой фабрики и возвращает её.
 *
 * Пример:
 *
 * class MyViewModel @AssistedInject constructor(...): BaseViewModel<MyState>(...) {
 *
 *   @AssistedInject.Factory
 *   interface Factory : AssistedViewModelFactory<MyViewModel, MyState> {
 *     ...
 *   }
 *
 *   companion object : DaggerMvRxViewModelFactory<MyViewModel, MyState>(MyViewModel::class.java)
 *
 * }
 */
abstract class DaggerMvRxViewModelFactory<VM : BaseViewModel<S>, S : MvRxState>(
    private val viewModelClass: Class<out BaseViewModel<S>>
) : MvRxViewModelFactory<VM, S> {

    override fun create(viewModelContext: ViewModelContext, state: S): VM? {
        return createViewModel(viewModelContext, state)
    }

    private fun <VM : BaseViewModel<S>, S : MvRxState> createViewModel(
        viewModelContext: ViewModelContext,
        state: S
    ): VM {
        val viewModelFactory = ComponentDependenciesHolder
            .getApplicationDependency<ViewModelDependencies>(viewModelContext.app())
            .viewModelFactories()[viewModelClass]

        @Suppress("UNCHECKED_CAST")
        val castedViewModelFactory = viewModelFactory as? AssistedViewModelFactory<VM, S>
        val viewModel = castedViewModelFactory?.create(state)
        return viewModel as VM
    }
}