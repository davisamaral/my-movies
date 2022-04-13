package com.davisamaral.mymovies.database.cache

import java.util.concurrent.TimeUnit

abstract class MemoryCache<K : Any, T>(
    cacheSource: CacheSource<K, T> = LruCacheSource()
) : BaseCache<K, T>(cacheSource) {
    override val cachePolicies: List<CachePolicy<T>> = listOf(
        ExpirationTimeCachePolicy(
            duration = 20,
            timeUnit = TimeUnit.SECONDS
        )
    )
}