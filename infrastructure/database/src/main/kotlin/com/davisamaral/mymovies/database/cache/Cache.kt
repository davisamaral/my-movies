package com.davisamaral.mymovies.database.cache

interface Cache<K, T> {
    val cachePolicies: List<CachePolicy<T>>
    val size: Int

    fun clear()
    fun delete(key: K)
    fun set(
        key: K,
        value: T
    )

    fun get(key: K): CacheData<out T>?
    fun getWithPolicies(key: K): T?
    suspend fun getWithSource(
        key: K,
        source: suspend () -> T
    ): T?
}
