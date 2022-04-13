import org.gradle.api.Plugin
import org.gradle.api.Project

class ConfigFeaturePresentationModulePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.apply {
            plugin("com.android.library")
            plugin("kotlin-android")
            plugin("custom-dependencies")
            plugin("de.mannodermaus.android-junit5")
            from("${target.rootDir}/build-plugins/scripts/config-android-presentation-module.gradle")
        }
        target.configFeatureModuleRepositories()
    }
}

fun Project.configFeatureModuleRepositories(): Unit = with(dependencies) {
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
    addNavigation()

    addDesignSystem()

    addUtilityKotlinExtensions()
    addUtilityAndroidExtensions()
    addUtilityNavigation()

    addInfrastructureConfigurationPublic()
}
