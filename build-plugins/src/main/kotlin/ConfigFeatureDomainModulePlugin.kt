import org.gradle.api.Plugin
import org.gradle.api.Project

class ConfigFeatureDomainModulePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.apply {
            plugin("kotlin")
            plugin("custom-dependencies")
            from("${target.rootDir}/build-plugins/scripts/config-kotlin-module.gradle")
        }
        target.configFeatureDomainModuleRepositories()
    }
}

fun Project.configFeatureDomainModuleRepositories(): Unit = with(dependencies) {
    addUtilityKotlinExtensions()
    addCoroutines()
    addKoin()

    addKotlinTests()
    addMocks()

    addInfrastructureConfigurationPublic()
}
