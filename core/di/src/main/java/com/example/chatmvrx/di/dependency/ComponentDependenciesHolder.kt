package com.example.chatmvrx.di.dependency

import android.app.Application
import android.content.Context
import java.lang.ref.WeakReference

/**
 * Класс предназначеный для упрощения работы с зависимостями между модулями.
 *
 * Для полноценной работы, этот класс должен быть в единственном экзамеляре в приложении.
 * Предпологается, что он создан в ApplicationComponent и далее с получается с помощью метода
 * [ComponentDependenciesHolder.getInstance], который в свою очередь берет это из Application, куда он должен
 * быть заинжекчен.
 *
 *
 * ## Инициализации:
 *
 * ### SampleApplicationComponent:
 * ```
 * @Singleton
 * @Component(modules = [
 *     ComponentDependenciesModule::class,
 *     ...
 * ])
 * interface SampleApplicationComponent : AndroidInjector<SampleApplication> {
 *
 *     @Component.Builder
 *     interface Builder {
 *
 *        fun build(): SampleApplicationComponent
 *        ...
 *     }
 * }
 * ```
 * ### Application:
 * ```
 * class SampleApplication : Application, HasComponentDependencies {
 *
 *     @Inject
 *     override lateinit var componentDependenciesHolder: ComponentDependenciesHolder
 *
 *     override lateinit var applicationComponent: SampleApplicationComponent
 *
 *     override fun onCreate() {
 *         super.onCreate()
 *
 *         applicationComponent = DaggerSampleApplicationComponent.builder()
 *             .context(this)
 *             .build()
 *
 *         applicationComponent.inject(this)
 *     }
 * }
 * ```
 *
 * @author Коваль Ростислав
 *
 * @see [CommonComponentDependencies]
 * @see [CacheableComponentDependencies]
 * @see [ApplicationComponentDependencies]
 * @see [HasComponentDependencies]
 */
class ComponentDependenciesHolder {

    companion object {

        /**
         * Метод предназначениый для получения инстанса класса из [Application]
         */
        fun getInstance(context: Context): ComponentDependenciesHolder =
            (context.applicationContext as HasComponentDependencies<*>).componentDependenciesHolder

        /**
         * Метод предназначениый для получения зависимостей объявленых в [Application]
         */
        @Suppress("UNCHECKED_CAST")
        fun <Component : ApplicationComponentDependencies> getApplicationDependency(context: Context): Component =
            ((context.applicationContext as HasComponentDependencies<*>).appComponent) as Component
    }

    /**
     * @property commonDependencyMap контейнер для CommonComponent, который хранит компоненты какое-то
     * время после уничтожения фичи в которой он был создан.
     * Дает возможность достать и переиспользовать CommonComponent не пересоздавая его.
     */
    private val commonDependencyMap: MutableMap<Class<out CommonComponentDependencies>, WeakReference<out CommonComponentDependencies>> =
        HashMap()

    /**
     * @property cacheableDependencyMap контейнер для CacheableComponentDependencies, который хранит
     * компоненты все время жизни приложения.
     * Некторые компоненты нам нужны в едином екземпляре в рамках приложения к примеру компонент,
     * который провайдит {@code LastLocationUseCase} с помощью которого мы можем подписаться на
     * {@code lastLocation: BehaviorSubject<Location>} из любого места приложения и это будет один и тот-же
     * инстанс {@code LastLocationUseCase} и {@code lastLocation: BehaviorSubject<Location>}.
     * В таком случчае {@code LastLocationUseCase} должен быть помечен как @Singleton
     */
    private val cacheableDependencyMap: MutableMap<Class<out CacheableComponentDependencies>, CacheableComponentDependencies> =
        HashMap()

    /**
     * Метод предназначениый для получения самоуничтожаемых зависимостей
     *
     * @param dependencyClass класс, по которому будет произведен поиск зависимостей
     * @param action описывает как можно создать новый компонент, в случае если не нашелся инстас
     */
    @Suppress("UNCHECKED_CAST")
    @Synchronized
    fun <Component : CommonComponentDependencies> getCommonComponent(
        dependencyClass: Class<Component>,
        action: () -> Component
    ): Component =
        (commonDependencyMap[dependencyClass]?.get() ?: action().apply {
            commonDependencyMap[dependencyClass] = WeakReference(this)
        }) as Component

    /**
     * Метод предназначениый для получения уничтожаемых вручную зависимостей
     *
     * @param dependencyClass класс, по которому будет произведен поиск зависимостей
     * @param action описывает как можно создать новый компонент, в случае если не нашелся инстас
     */
    @Suppress("UNCHECKED_CAST")
    @Synchronized
    fun <Component : CacheableComponentDependencies> getCacheableComponent(
        dependencyClass: Class<Component>,
        action: () -> Component
    ): Component =
        (cacheableDependencyMap[dependencyClass] ?: action().apply {
            cacheableDependencyMap[dependencyClass] = this
        }) as Component

    /**
     * Метод предназначениый для уничтожения зависимостей, который не могут этого деоать сами
     *
     * @param dependencyClass класс, по которому будет произведен поиск зависимостией
     */
    @Synchronized
    fun releaseCachableComponent(dependencyClass: Class<out CacheableComponentDependencies>) {
        cacheableDependencyMap.remove(dependencyClass)
    }
}