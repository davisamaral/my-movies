import org.gradle.api.Plugin
import org.gradle.api.Project

class DependenciesPlugin : Plugin<Project> {
    override fun apply(target: Project) = Unit
}

object SharedVersions {
    const val kotlin = "1.5.31"
}

object Navigation {
    object Versions {
        const val version = "2.4.1"
    }

    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.version}"
    const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.version}"
    const val navigationCompose = "androidx.navigation:navigation-compose:${Versions.version}"
    const val navigationTesting = "androidx.navigation:navigation-testing:${Versions.version}"
    const val accompanistNavigationAnimation = "com.google.accompanist:accompanist-navigation-animation:0.24.5-alpha"
}


object Lifecycle {
    object Versions {
        const val lifecycle = "2.4.1"
        const val lifecycleTesting = "2.1.0"
    }

    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val test = "androidx.arch.core:core-testing:${Versions.lifecycleTesting}"
}

object Coroutines {
    object Versions {
        const val coroutines = "1.5.2"
    }

    const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"

    const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
}

object Koin {
    object Versions {
        const val koin = "3.1.5"
    }

    const val core = "io.insert-koin:koin-core:${Versions.koin}"
    const val android = "io.insert-koin:koin-android:${Versions.koin}"

    const val test = "io.insert-koin:koin-test-junit4:${Versions.koin}"
    const val coreTest = "io.insert-koin:koin-test:${Versions.koin}"
    const val androidTest = "io.insert-koin:koin-test-junit4:${Versions.koin}"
}

object Retrofit {
    object Versions {
        const val retrofit = "2.9.0"
        const val moshi = "1.13.0"
    }

    const val core = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val moshi = "com.squareup.moshi:moshi:${Versions.moshi}"
    const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:${Versions.moshi}"
    const val moshiKapt = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"
}

object AndroidX {
    object Versions {
        const val ktx = "1.7.0"
        const val appcompat = "1.4.1"
        const val design = "1.1.0"
        const val recyclerView = "1.2.1"
        const val annotation = "1.1.1"
        const val fragment = "1.3.6"
        const val constraintLayout = "2.1.3"
    }

    const val ktx = "androidx.core:core-ktx:${Versions.ktx}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val materialDesign = "com.google.android.material:material:${Versions.design}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    const val annotations = "androidx.annotation:annotation:${Versions.annotation}"
    const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
}

object Compose {
    private const val composeVersion = "1.1.1"
    private const val pagingVersion = "1.0.0-alpha14"

    const val paging = "androidx.paging:paging-compose:$pagingVersion"
    const val ui = "androidx.compose.ui:ui:$composeVersion"
    const val uiTooling = "androidx.compose.ui:ui-tooling:$composeVersion"
    const val foundation = "androidx.compose.foundation:foundation:$composeVersion"
    const val material = "androidx.compose.material:material:$composeVersion"
    const val materialIcons = "androidx.compose.material:material-icons-core:$composeVersion"
    const val materialIconsExtended = "androidx.compose.material:material-icons-extended:$composeVersion"
    const val runtimeLivedata = "androidx.compose.runtime:runtime-livedata:$composeVersion"
    const val test = "androidx.compose.ui:ui-test-junit4:$composeVersion"
}

object Coil{
    private const val version = "2.0.0-rc02"

    const val coil = "io.coil-kt:coil:$version"
    const val coilCompose = "io.coil-kt:coil-compose:$version"
}

object KotlinTest {
    private const val version = "5.8.2"

    const val jupiterApi = "org.junit.jupiter:junit-jupiter-api:$version"
    const val jupiterEngine = "org.junit.jupiter:junit-jupiter-engine:$version"
    const val jupiterParams = "org.junit.jupiter:junit-jupiter-params:$version"
    const val vintageEngine = "org.junit.vintage:junit-vintage-engine:$version"
    const val junit = "org.jetbrains.kotlin:kotlin-test-junit:${SharedVersions.kotlin}"
}

object AndroidTest {
    object Versions {
        const val test = "1.2.0"
        const val junit = "1.1.1"
        const val espresso = "3.2.0"
        const val robolectric = "4.7.3"
    }

    const val ext = "androidx.test.ext:junit:${Versions.junit}"
    const val rules = "androidx.test:rules:${Versions.test}"
    const val runner = "androidx.test:runner:${Versions.test}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val espressoContrib = "androidx.test.espresso:espresso-contrib:${Versions.espresso}"
    const val orchestrator = "androidx.test:orchestrator:${Versions.test}"
    const val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"
}

object MockK {
    object Versions {
        const val mockk = "1.12.3"
    }

    const val core = "io.mockk:mockk:${Versions.mockk}"
    const val android = "io.mockk:mockk-android:${Versions.mockk}"
}