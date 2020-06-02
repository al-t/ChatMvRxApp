package com.example.chatmvrx.di.dependency

import java.lang.ref.WeakReference

/**
 * Интерфейс метка, предназначеный для маркировки ComponentDependency интерфейсов,
 * которые должны быть инициализованы до момента, пока есть компоненты которые ссылаются на
 * эти классы.
 *
 * Предпологается, что данная dependency может быть уничтожена в любой момент времени,
 * т.к. реализацию базируется на [WeakReference]
 *
 * @author Коваль Ростислав
 *
 * @see [ApplicationComponentDependencies]
 * @see [CacheableComponentDependencies]
 * @see [WeakReference]
 */
interface CommonComponentDependencies