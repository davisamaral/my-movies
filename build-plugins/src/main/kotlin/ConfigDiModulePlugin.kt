import org.gradle.api.Plugin
import org.gradle.api.Project

class ConfigDiModulePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.apply {
            plugin("com.android.library")
            plugin("kotlin-android")
            plugin("custom-dependencies")
            plugin("de.mannodermaus.android-junit5")
            from("${target.rootDir}/build-plugins/scripts/config-android-module.gradle")
        }
        target.configDiModuleRepositories()
    }
}

fun Project.configDiModuleRepositories(): Unit = with(dependencies) {
    addKoinAndroid()
}
