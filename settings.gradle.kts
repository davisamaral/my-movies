rootProject.name = "my-movies"

apply(from = "$rootDir/modules.gradle.kts")

includeBuild("build-plugins")