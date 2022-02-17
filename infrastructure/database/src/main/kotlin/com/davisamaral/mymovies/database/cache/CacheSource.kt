package com.davisamaral.mymovies.database.cache

interface CacheSource<K, T> {
    val size: Int

    fun createCacheData(value: T): CacheData<out T>

    fun clear()

    fun deleteCache(key: K)

    operator fun get(key: K): CacheData<out T>?

    operator fun set(
        key: K,
        value: CacheData<out T>
    )
}
