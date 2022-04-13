package com.davisamaral.mymovies.configuration.impl.startup

import com.davisamaral.mymovies.configuration.startup.AppStartupListener
import com.davisamaral.mymovies.configuration.startup.AppStartupNotifier

class DefaultAppStartupNotifier(
    private val appStartupListeners: Set<AppStartupListener>
) : AppStartupNotifier {
    override fun notifyAppStartup() {
        appStartupListeners.forEach { listener ->
            listener.onAppStartup()
        }
    }
}