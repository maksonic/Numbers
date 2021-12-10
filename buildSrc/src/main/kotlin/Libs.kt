/**
 * @Author: maksonic on 08.12.2021
 */
object Libs {
    object AndroidX {

        const val appCompat = "androidx.appcompat:appcompat:1.4.0"
        const val activity = "androidx.activity:activity-ktx:1.4.0"
        const val coreKtx = "androidx.core:core-ktx:1.7.0"
        const val material = "com.google.android.material:material:1.6.0-alpha01"
    }

    object Navigation {
        private const val version = "2.4.0-beta02"
        const val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:$version"
        const val uiKtx = "androidx.navigation:navigation-ui-ktx:$version"

    }

    object Emoji {
        private const val version = "1.0.0"
        const val bundled = "androidx.emoji2:emoji2-bundled:$version"
        const val init = "androidx.emoji2:emoji2:$version"
    }

    object Koin {
        private const val version = "3.1.4"
        const val android = "io.insert-koin:koin-android:$version"
    }
    object Lifecycle {
        private const val version = "2.4.0"
        const val runtimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
        const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
    }

    object OkHttp {
        private const val version = "5.0.0-alpha.2"
        const val interceptor = "com.squareup.okhttp3:logging-interceptor:$version"
    }

    object Jetbrains {
        private const val version = "1.5.2"

        const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.1"
    }

    object Retrofit {
        private const val version = "2.9.0"
        const val retofit = "com.squareup.retrofit2:retrofit:$version"
        const val converter = "com.squareup.retrofit2:converter-gson:$version"
    }

    object TestLibraries {
        const val junit = "junit:junit:4.13"
    }

    object AndroidTestLibraries {
        const val junitExt = "androidx.test.ext:junit:1.1.3"
        const val runner = "androidx.test:runner:1.2.0"

        object Espresso {
            private const val version = "3.4.0"
            const val core = "androidx.test.espresso:espresso-core:$version"
        }
    }
}