import org.gradle.api.Plugin
import org.gradle.api.Project

class ConfigAndroidModulePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.apply {
            plugin("com.android.library")
            plugin("kotlin-android")
            plugin("custom-dependencies")
            plugin("de.mannodermaus.android-junit5")
            from("${target.rootDir}/build-plugins/scripts/config-android-module.gradle")
        }
        target.configAndroidModuleRepositories()
    }
}

fun Project.configAndroidModuleRepositories(): Unit = with(dependencies) {
    addCoroutines()
    addKoinAndroid()
    addKtx()

    addKotlinTests()
    addAndroidTests()
    addMocks()

    addUtilityKotlinExtensions()
}
