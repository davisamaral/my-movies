package com.davisamaral.mymovies.database.cache

import java.util.*

internal fun getToday(
    timeZone: TimeZone = TimeZone.getDefault()
): Calendar = Calendar.getInstance(timeZone)

internal fun Date.toCalendar(
    timeZone: TimeZone = TimeZone.getDefault()
): Calendar = Calendar.getInstance(timeZone).apply { time = this@toCalendar }
