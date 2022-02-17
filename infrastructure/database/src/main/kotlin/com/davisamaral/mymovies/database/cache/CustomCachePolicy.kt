package com.davisamaral.mymovies.database.cache

class CustomCachePolicy<T>(private val isValid: ((CacheData<out T>?) -> Boolean)) : CachePolicy<T> {
    override fun isNotExpired(cacheData: CacheData<out T>?): Boolean = isValid.invoke(cacheData)
}
