package com.davisamaral.mymovies.database.cache

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

abstract class BaseCache<K, T>(
    private val cacheSource: CacheSource<K, T>
) : CoroutineScope by CoroutineScope(Dispatchers.IO), Cache<K, T> {

    override val cachePolicies: List<CachePolicy<T>> = emptyList()

    override val size: Int
        get() = cacheSource.size

    override fun clear() {
        cacheSource.clear()
    }

    override fun delete(key: K) {
        cacheSource.deleteCache(key)
    }

    override fun set(
        key: K,
        value: T
    ) {
        cacheSource[key] = cacheSource.createCacheData(value)
    }

    override fun getWithPolicies(key: K): T? {
        val cacheData = get(key)
        return if (cacheData != null && isValidCache(cacheData)) {
            cacheData.data
        } else {
            null
        }
    }

    override suspend fun getWithSource(
        key: K,
        source: suspend () -> T
    ): T? {
        val cacheData = get(key)
        return if (cacheData != null && isValidCache(cacheData)) {
            cacheData.data
        } else {
            getFromSource(source, key)
        }
    }

    override fun get(key: K) = cacheSource[key]

    private fun isValidCache(result: CacheData<out T>?): Boolean =
        cachePolicies.isEmpty() || cachePolicies.all { policy -> policy.isNotExpired(result) }

    private suspend fun getFromSource(
        source: suspend () -> T,
        key: K
    ): T? {
        val result = source()
        set(key, result)
        return result
    }
}
