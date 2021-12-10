plugins {
    androidApp()
    kotlinAndroid()
}

android {
    compileSdk = ProjectConfig.compileSdk

    defaultConfig {
        applicationId = ProjectConfig.applicationId
        minSdk = ProjectConfig.minSdk
        targetSdk = ProjectConfig.targetSdk
        versionCode = ProjectConfig.versionCode
        versionName = ProjectConfig.versionName

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
    implementation(Libs.AndroidX.coreKtx)
    implementation(Libs.AndroidX.appCompat)
    implementation(Libs.Koin.android)
    implementation(Libs.AndroidX.material)
    implementation(Libs.Navigation.fragmentKtx)
    implementation(Libs.Navigation.uiKtx)

    testImplementation(Libs.TestLibraries.junit)
    androidTestImplementation(Libs.AndroidTestLibraries.junitExt)
    androidTestImplementation(Libs.AndroidTestLibraries.Espresso.core)
}