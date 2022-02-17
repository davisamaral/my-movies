package com.davisamaral.mymovies.database.cache

import java.util.*

data class CacheData<T>(
    var data: T?,
    val createdAt: Date = Calendar.getInstance().time
)
