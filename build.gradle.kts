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
    }
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}