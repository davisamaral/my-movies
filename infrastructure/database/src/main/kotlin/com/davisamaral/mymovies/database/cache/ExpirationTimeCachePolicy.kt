package com.davisamaral.mymovies.database.cache

import java.util.*
import java.util.concurrent.TimeUnit

class ExpirationTimeCachePolicy<T>(
    private val duration: Int,
    private val timeUnit: TimeUnit
) : CachePolicy<T> {

    override fun isNotExpired(cacheData: CacheData<out T>?): Boolean = cacheData?.let {
        cacheData.createdAt.isValidDate(duration, timeUnit)
    } ?: false

    private fun Date.isValidDate(
        duration: Int,
        timeUnit: TimeUnit
    ): Boolean {
        val currentDate = getToday()
        val expiredDate = this.toCalendar().apply {
            add(convertCalendarTimeUnit(timeUnit), duration)
        }
        return currentDate.before(expiredDate)
    }

    @Suppress("TooGenericExceptionThrown")
    internal fun convertCalendarTimeUnit(timeUnit: TimeUnit): Int {
        return when (timeUnit) {
            TimeUnit.NANOSECONDS -> throw RuntimeException("NANOSECONDS is not supported from cache")
            TimeUnit.MICROSECONDS -> throw RuntimeException("MICROSECONDS is not supported from cache")
            TimeUnit.MILLISECONDS -> Calendar.MILLISECOND
            TimeUnit.SECONDS -> Calendar.SECOND
            TimeUnit.MINUTES -> Calendar.MINUTE
            TimeUnit.HOURS -> Calendar.HOUR
            TimeUnit.DAYS -> Calendar.DAY_OF_YEAR
        }
    }
}
