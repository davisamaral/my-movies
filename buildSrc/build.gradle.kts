buildscript {
    val kotlinVersion = "1.6.10"

    repositories {
        mavenCentral()
    }

    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }
}

apply(plugin = "kotlin")

repositories {
    mavenCentral()
}
