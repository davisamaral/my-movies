package com.davisamaral.mymovies.database.cache

interface CachePolicy<T> {
    fun isNotExpired(cacheData: CacheData<out T>?): Boolean
}
