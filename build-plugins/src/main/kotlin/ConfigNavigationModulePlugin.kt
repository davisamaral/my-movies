import org.gradle.api.Plugin
import org.gradle.api.Project

class ConfigNavigationModulePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.apply {
            plugin("com.android.library")
            plugin("kotlin-android")
            plugin("androidx.navigation.safeargs")
            from("${target.rootDir}/build-plugins/scripts/config-android-module.gradle")
        }
        target.configNavigationModuleRepositories()
    }
}

fun Project.configNavigationModuleRepositories(): Unit = with(dependencies) {
    addFragment()
    addNavigation()
}
