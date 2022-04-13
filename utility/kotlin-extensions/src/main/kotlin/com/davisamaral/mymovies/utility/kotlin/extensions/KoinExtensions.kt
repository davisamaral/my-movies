package com.davisamaral.mymovies.utility.kotlin.extensions

import org.koin.core.Koin
import org.koin.core.error.DefinitionOverrideException
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope
import org.koin.dsl.onClose
import org.koin.ext.getFullName
import java.util.*


@PublishedApi
internal class Multibinding<T> : MutableSet<T> by mutableSetOf()

inline fun <reified T : Any> Module.intoMultibinding(noinline value: Scope.() -> T) {

    var multibinding: Multibinding<T>? = null
    var multibindingItem: T? = null
    val multibindingQualifier = named(T::class.getFullName())
    val itemQualifier = named(T::class.getFullName() + "_" + UUID.randomUUID())

    try {
        this@intoMultibinding.single(qualifier = named(T::class.getFullName())) { Multibinding<T>() }
    } catch (e: DefinitionOverrideException) {
    }


    single(
        qualifier = itemQualifier,
        createdAtStart = true,
    ) {
        val calculatedValue = value()
        multibindingItem = calculatedValue
        multibinding = getOrNull(multibindingQualifier)
        multibinding?.add(calculatedValue)
    }.onClose {
        multibinding?.remove(multibindingItem)
    }

}

inline fun <reified T> Koin.getMultibinding(): Set<T> =
    getOrNull<Multibinding<T>>(named(T::class.getFullName())).orEmpty()


inline fun <reified T : Any> Koin.injectMultibinding(
    mode: LazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED,
) = lazy(mode) { getMultibinding<T>() }