import org.gradle.api.Plugin
import org.gradle.api.Project

class ConfigAndroidDesignSystemModulePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.apply {
            plugin("com.android.library")
            plugin("kotlin-android")
            plugin("custom-dependencies")
            plugin("de.mannodermaus.android-junit5")
            from("${target.rootDir}/build-plugins/scripts/config-android-presentation-module.gradle")
        }
        target.configAndroidDesignSystemModuleRepositories()
    }
}

fun Project.configAndroidDesignSystemModuleRepositories(): Unit = with(dependencies) {
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
    addCoil()
    addFragment()

    addInfrastructureConfigurationPublic()
}
