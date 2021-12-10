// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(BuildPlugin.KotlinGradle.init)
        classpath(BuildPlugin.BuildToolsGradle.init)
        classpath(BuildPlugin.KotlinxSerialization.init)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.0")
    }
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}