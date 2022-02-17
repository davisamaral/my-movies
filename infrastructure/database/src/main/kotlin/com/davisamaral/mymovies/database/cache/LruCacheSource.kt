package com.davisamaral.mymovies.database.cache

import androidx.collection.LruCache


private const val DEFAULT_SIZE = 4 * 1024 * 1024 // 4mb

class LruCacheSource<K, T>(cacheSize: Int = DEFAULT_SIZE) : CacheSource<K, T> {

    private val inMemoryDb: LruCache<K, CacheData<out T>> = LruCache(cacheSize)

    override val size: Int
        get() = inMemoryDb.size()

    override fun clear() {
        inMemoryDb.evictAll()
    }

    override fun deleteCache(key: K) {
        inMemoryDb.remove(key)
    }

    override fun get(key: K): CacheData<out T>? = inMemoryDb[key]

    override fun set(
        key: K,
        value: CacheData<out T>
    ) {
        inMemoryDb.put(key, value)
    }

    override fun createCacheData(value: T) = CacheData(value)
}
