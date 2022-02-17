import org.gradle.api.Plugin
import org.gradle.api.Project

class ConfigFeatureNavigationModulePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.apply {
            plugin("com.android.library")
            plugin("kotlin-android")
            plugin("custom-dependencies")
            plugin("de.mannodermaus.android-junit5")
            plugin("androidx.navigation.safeargs")
            from("${target.rootDir}/build-plugins/scripts/config-android-presentation-module.gradle")
        }
        target.configFeatureNavigationModuleRepositories()
    }
}

fun Project.configFeatureNavigationModuleRepositories(): Unit = with(dependencies) {
    addCoroutines()
    addKoinAndroid()

    addKotlinTests()
    addAndroidTests()
    addMocks()

    addFragment()
    addCompose()
    addUtilityNavigation()
    addNavigation()
}
