import org.gradle.api.Project

fun Project.addKtx() = with(dependencies) {
    add("implementation", AndroidX.ktx)
}

fun Project.addAppcompat() = with(dependencies) {
    add("implementation", AndroidX.appCompat)
}

fun Project.addDesign() = with(dependencies) {
    add("implementation", AndroidX.materialDesign)
}

fun Project.addRecyclerview() = with(dependencies) {
    add("implementation", AndroidX.recyclerView)
}

fun Project.addConstraintLayout() = with(dependencies) {
    add("implementation", AndroidX.constraintLayout)
}

fun Project.addFragment() = with(dependencies) {
    add("implementation", AndroidX.fragment)
}

fun Project.addCompose() = with(dependencies) {
    add("implementation", Compose.ui)
    add("implementation", Compose.paging)
    add("implementation", Compose.uiTooling)
    add("implementation", Compose.foundation)
    add("implementation", Compose.material)
    add("implementation", Compose.materialIcons)
    add("implementation", Compose.materialIconsExtended)
    add("implementation", Compose.runtimeLivedata)
    add("androidTestImplementation", Compose.test)
}

fun Project.addCoil() = with(dependencies) {
    add("implementation", Coil.coil)
    add("implementation", Coil.coilCompose)
}

fun Project.addCoroutines() = with(dependencies) {
    add("implementation", Coroutines.core)
    add("implementation", Coroutines.android)
    add("testImplementation", Coroutines.test)
}

fun Project.addKoin() = with(dependencies) {
    add("implementation", Koin.core)
    add("testImplementation", Koin.coreTest)
}

fun Project.addKoinAndroid() = with(dependencies) {
    add("implementation", Koin.android)
    add("testImplementation", Koin.test)
    add("androidTestImplementation", Koin.androidTest)
}

fun Project.addKotlinTests() = with(dependencies) {
    add("testImplementation", KotlinTest.junit)
    add("testImplementation", KotlinTest.jupiterApi)
    add("testRuntimeOnly", KotlinTest.jupiterEngine)
    add("testImplementation", KotlinTest.jupiterParams)
    add("testRuntimeOnly", KotlinTest.vintageEngine)
}

fun Project.addAndroidTests() = with(dependencies) {
    add("androidTestImplementation", AndroidTest.ext)
    add("androidTestImplementation", AndroidTest.rules)
    add("androidTestImplementation", AndroidTest.runner)
    add("androidTestImplementation", AndroidTest.espresso)
    add("androidTestImplementation", AndroidTest.espressoContrib)
    add("androidTestImplementation", AndroidTest.orchestrator)
    add("testImplementation", AndroidTest.robolectric)
}

fun Project.addMocks() = with(dependencies) {
    add("testImplementation", MockK.core)
}

fun Project.addLifecycle() = with(dependencies) {
    add("implementation", Lifecycle.viewModel)
    add("implementation", Lifecycle.liveData)
    add("testImplementation", Lifecycle.test)
}

fun Project.addNavigation() = with(dependencies) {
    add("implementation", Navigation.navigationFragment)
    add("implementation", Navigation.navigationCompose)
    add("implementation", Navigation.navigationUi)
    add("implementation", Navigation.accompanistNavigationAnimation)
    add("androidTestImplementation", Navigation.navigationTesting)
}

fun Project.addRetrofit() = with(dependencies) {
    add("implementation", Retrofit.core)
    add("implementation", Retrofit.moshiConverter)
    add("implementation", Retrofit.moshi)
    add("implementation", Retrofit.moshiKotlin)
    add("kapt", Retrofit.moshiKapt)
}