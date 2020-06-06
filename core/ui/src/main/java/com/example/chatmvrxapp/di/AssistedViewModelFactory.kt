package com.example.chatmvrxapp.di

import com.airbnb.mvrx.MvRxState
import com.example.chatmvrxapp.presentation.BaseViewModel

/**
 * Базовый интерфейс для AssistedInject фабрик вьюмоделей.
 *
 * Служит в качестве маркера при настройке Multibinding Dagger, чтобы заполнить карту вьюмоделей и
 * соответствующих им AssistedInject фабрик.
 *
 * Пример:
 *
 * Вначале мы указываем для конструктора нашей вьюмодели аннотацию @AssistedInject и внутри создаём
 * интерфейс фабрики, наследующей AssistedViewModelFactory таким образом:
 *
 * class MyViewModel @AssistedInject constructor(...): BaseViewModel<MyState>(...) {
 *   @AssistedInject.Factory
 *   interface Factory : AssistedViewModelFactory<MyViewModel, MyState> {
 *     override fun create(state: MyState): MyViewModel
 *   }
 * }
 *
 * Затем необходимо создать Даггер-модуль, содержащий метод, который байндит нашу фабрику вьмодели
 * в общую карту используя в качестве ключа [ViewModelKey] класс нашей вьюмодели:
 *
 * @AssistedModule(includes = [AssistedInject_MyAppModule::class])
 * @Module
 * interface MyAppModule {
 *   @Binds
 *   @IntoMap
 *   @ViewModelKey(MyViewModel::class)
 *   fun myViewModelFactory(factory: MyViewModel.Factory): AssistedViewModelFactory<*, *>
 * }
 *
 * Сгенерированная Даггером карта используется затем для полученя нужной фабрики вьюмодели.
 */
interface AssistedViewModelFactory<VM : BaseViewModel<S>, S : MvRxState> {

    /**
     * Метод для создания вьмодели [BaseViewModel] с состоянием [MvRxState]
     *
     * @param state состояние вьюмодели
     */
    fun create(state: S): VM
}
