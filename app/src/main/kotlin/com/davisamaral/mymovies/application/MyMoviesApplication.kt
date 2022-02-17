package com.davisamaral.mymovies.application

import android.app.Application
import android.content.Context
import com.davisamaral.mymovies.di.appModule
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyMoviesApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin(this)
    }

    private fun initKoin(context: Context) {
        startKoin {
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(context)
            fragmentFactory()
            modules(appModule)
        }
    }
}