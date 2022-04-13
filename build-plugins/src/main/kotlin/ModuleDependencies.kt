import org.gradle.api.Project


fun Project.addUtilityKotlinExtensions() = add { utilityKotlinExtensions }
fun Project.addUtilityNavigation() = add { utilityNavigation }
fun Project.addUtilityAndroidExtensions() = add { utilityAndroidExtensions }

fun Project.addDesignSystem() = add { designSystem }

fun Project.addInfrastructureNetwork() = add { infrastructureNetwork }
fun Project.addInfrastructureDatabase() = add { infrastructureDatabase }
fun Project.addInfrastructureConfigurationDi() = add { infrastructureConfigurationDi }
fun Project.addInfrastructureConfigurationPublic() = add { infrastructureConfigurationPublic }
fun Project.addInfrastructureConfigurationImpl() = add { infrastructureConfigurationImpl }

fun Project.addFeatureMovieDi() = add { featureMovieDi }
fun Project.addFeatureMovieNavigationPublic() = add { featureMovieNavigationPublic }
fun Project.addFeatureMovieNavigationImpl() = add { featureMovieNavigationImpl }
fun Project.addFeatureMovieData() = add { featureMovieData }
fun Project.addFeatureMovieDomainPublic() = add { featureMovieDomainPublic }
fun Project.addFeatureMovieDomainImpl() = add { featureMovieDomainImpl }
fun Project.addFeatureMoviePresentationList() = add { featureMoviePresentationList }
fun Project.addFeatureMoviePresentationDetail() = add { featureMoviePresentationDetail }

fun Project.addFeatureSplashDi() = add { featureSplashDi }
fun Project.addFeatureSplashNavigationPublic() = add { featureSplashNavigationPublic }
fun Project.addFeatureSplashNavigationImpl() = add { featureSplashNavigationImpl }
fun Project.addFeatureSplashPresentationSplash() = add { featureSplashPresentationSplash }

private fun Project.add(block: Modules.() -> String) = with(dependencies) {
    add("implementation", project(block(Modules)))
}
