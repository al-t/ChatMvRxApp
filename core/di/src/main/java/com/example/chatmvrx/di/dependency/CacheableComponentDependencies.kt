package com.example.chatmvrx.di.dependency

/**
 * Интерфейс метка, предназначеный для маркировки ComponentDependency интерфейсов,
 * которые должны быть инициализованы до момента, пока кто-то вручную их не освободит
 * с помощью [ComponentDependenciesHolder.releaseCachableComponent]
 *
 * @see [ApplicationComponentDependencies]
 * @see [CommonComponentDependencies]
 */
interface CacheableComponentDependencies