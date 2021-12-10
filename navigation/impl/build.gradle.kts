plugins {
    androidLibrary()
    kotlinAndroid()
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
    implementation(project(Module.Navigation.api))
    implementation(project(Module.Screen.main))
    implementation(project(Module.Screen.about))

    implementation(Libs.Navigation.fragmentKtx)
    implementation(Libs.Navigation.uiKtx)

    testImplementation(Libs.TestLibraries.junit)
    androidTestImplementation(Libs.AndroidTestLibraries.junitExt)
    androidTestImplementation(Libs.AndroidTestLibraries.Espresso.core)
}