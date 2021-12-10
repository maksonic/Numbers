import org.gradle.kotlin.dsl.kotlin
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

/**
 * @Author: maksonic on 08.12.2021
 */
fun PluginDependenciesSpec.androidApp(): PluginDependencySpec =
    id("com.android.application")

fun PluginDependenciesSpec.androidLibrary(): PluginDependencySpec =
    id("com.android.library")

fun PluginDependenciesSpec.googleServices(): PluginDependencySpec =
    id("com.google.gms.google-services")

fun PluginDependenciesSpec.kapt(): PluginDependencySpec =
    id("kotlin-kapt")

fun PluginDependenciesSpec.hilt(): PluginDependencySpec =
    id("dagger.hilt.android.plugin")

fun PluginDependenciesSpec.kotlinAndroid(): PluginDependencySpec =
    kotlin("android")

fun PluginDependenciesSpec.kotlinxSerialization(): PluginDependencySpec =
    id("kotlinx-serialization")

fun PluginDependenciesSpec.navigationSafeArgs(): PluginDependencySpec =
    id("androidx.navigation.safeargs")