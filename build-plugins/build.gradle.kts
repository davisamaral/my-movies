plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

repositories {
    mavenCentral()
}

enum class CustomPlugin(
    val id: String,
    val implementationClass: String
) {
    CUSTOM_DEPENDENCIES(
        id = "custom-dependencies",
        implementationClass = "DependenciesPlugin"
    ),
    CONFIG_FEATURE_DATA_MODULE(
        id = "config-feature-data-module",
        implementationClass = "ConfigFeatureDataModulePlugin"
    ),
    CONFIG_FEATURE_DOMAIN_MODULE(
        id = "config-feature-domain-module",
        implementationClass = "ConfigFeatureDomainModulePlugin"
    ),
    CONFIG_FEATURE_PRESENTATION_MODULE(
        id = "config-feature-presentation-module",
        implementationClass = "ConfigFeaturePresentationModulePlugin"
    ),
    CONFIG_ANDROID_MODULE(
        id = "config-android-module",
        implementationClass = "ConfigAndroidModulePlugin"
    ),
    CONFIG_ANDROID_DESIGN_SYSTEM_MODULE(
        id = "config-android-design-system-module",
        implementationClass = "ConfigAndroidDesignSystemModulePlugin"
    ),
    CONFIG_KOTLIN_MODULE(
        id = "config-kotlin-module",
        implementationClass = "ConfigKotlinModulePlugin"
    ),
    CONFIG_DI_MODULE(
        id = "config-di-module",
        implementationClass = "ConfigDiModulePlugin"
    ),
    CONFIG_NAVIGATION_MODULE(
        id = "config-navigation-module",
        implementationClass = "ConfigNavigationModulePlugin"
    ),
    CONFIG_FEATURE_NAVIGATION_MODULE(
        id = "config-feature-navigation-module",
        implementationClass = "ConfigFeatureNavigationModulePlugin"
    ),
    CONFIG_APP_MODULE(
        id = "config-app-module",
        implementationClass = "ConfigAppModulePlugin"
    );
}

gradlePlugin {
    CustomPlugin.values().forEach { customPlugin ->
        plugins.create(customPlugin.id) {
            id = customPlugin.id
            implementationClass = customPlugin.implementationClass
        }
    }
}
