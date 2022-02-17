object ApplicationId {
    const val id = "com.davisamaral.mymovies"
}

object Versions {
    const val compileSdk = 31
    const val minSdk = 21
    const val targetSdk = 31
    const val compose = "1.1.0"
}

object GradlePlugin {
    object Versions {
        const val kotlin = "1.6.10"
        const val googleServices = "4.3.10"
        const val androidGradlePlugin = "7.1.2"
        const val junit5 = "1.8.0.0"
        const val navigationSafeArgs = "2.4.1"
    }

    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val googleServices = "com.google.gms:google-services:${Versions.googleServices}"
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"
    const val junit5 = "de.mannodermaus.gradle.plugins:android-junit5:${Versions.junit5}"
    const val navigationSafeArgsGradlePlugin =
        "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigationSafeArgs}"
}

object Releases {
    const val versionCode = 10000
    const val versionName = "1.0.0"
}
