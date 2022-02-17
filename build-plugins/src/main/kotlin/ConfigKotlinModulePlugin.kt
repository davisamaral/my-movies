import org.gradle.api.Plugin
import org.gradle.api.Project

class ConfigKotlinModulePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.apply {
            plugin("kotlin")
            plugin("custom-dependencies")
            from("${target.rootDir}/build-plugins/scripts/config-kotlin-module.gradle")
        }
        target.configKotlinModuleRepositories()
    }
}

fun Project.configKotlinModuleRepositories(): Unit = with(dependencies) {
    addCoroutines()
    addKoin()

    addKotlinTests()
    addMocks()
}
