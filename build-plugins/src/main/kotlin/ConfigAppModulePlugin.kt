import org.gradle.api.Plugin
import org.gradle.api.Project

class ConfigAppModulePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.apply {
            plugin("com.android.application")
            plugin("kotlin-android")
            plugin("custom-dependencies")
            plugin("androidx.navigation.safeargs")
            plugin("de.mannodermaus.android-junit5")
            from("${target.rootDir}/build-plugins/scripts/config-app-module.gradle")
        }
        target.configAppModuleRepositories()
    }
}

fun Project.configAppModuleRepositories(): Unit = with(dependencies) {
    addCoroutines()
    addKoinAndroid()
    addKtx()

    addKotlinTests()
    addAndroidTests()
    addMocks()

    addLifecycle()
    addDesign()
    addAppcompat()
    addRecyclerview()
    addConstraintLayout()
    addCompose()
    addFragment()
    addNavigation()

    addDesignSystem()

    addUtilityNavigation()
    addUtilityAndroidExtensions()
    addUtilityKotlinExtensions()

    addInfrastructureNetwork()
    addInfrastructureDatabase()
    addInfrastructureConfigurationDi()
    addInfrastructureConfigurationPublic()

    addFeatureMovieDi()
    addFeatureMovieNavigationPublic()
}
