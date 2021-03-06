plugins {
    androidLibrary()
    kotlinAndroid()
    kotlinxSerialization()
}

android {
    compileSdk = ProjectConfig.compileSdk

    defaultConfig {
        minSdk = ProjectConfig.minSdk
        targetSdk = ProjectConfig.targetSdk

        testInstrumentationRunner = ProjectConfig.androidJunitRunner
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false

            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = ProjectConfig.jvmTarget
    }
}

dependencies {
    implementation(project(Module.domain))
    implementation(project(Module.core))

    implementation(Libs.Koin.android)
    implementation(Libs.OkHttp.interceptor)
    implementation(Libs.Jetbrains.coroutinesAndroid)
    implementation(Libs.Jetbrains.serialization)
    implementation(Libs.Retrofit.retofit)
    implementation(Libs.Retrofit.converter)

    testImplementation(Libs.TestLibraries.junit)
    androidTestImplementation(Libs.AndroidTestLibraries.junitExt)
    androidTestImplementation(Libs.AndroidTestLibraries.Espresso.core)
}