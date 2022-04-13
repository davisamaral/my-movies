import org.gradle.api.Plugin
import org.gradle.api.Project

class ConfigFeatureDataModulePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.apply {
            plugin("com.android.library")
            plugin("kotlin-android")
            plugin("custom-dependencies")
            plugin("de.mannodermaus.android-junit5")
            plugin("de.mannodermaus.android-junit5")
            plugin("kotlin-kapt")
            from("${target.rootDir}/build-plugins/scripts/config-android-module.gradle")
        }
        target.configFeatureDataModuleRepositories()
    }
}

fun Project.configFeatureDataModuleRepositories(): Unit = with(dependencies) {
    addCoroutines()
    addKoinAndroid()
    addKtx()

    addKotlinTests()
    addAndroidTests()
    addMocks()
    addRetrofit()

    addInfrastructureNetwork()
    addInfrastructureDatabase()
    addInfrastructureConfigurationPublic()
}
