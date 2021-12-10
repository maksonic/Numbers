/**
 * @Author: maksonic on 08.12.2021
 */
object BuildPlugin {


    object KotlinGradle {
        const val version = "1.6.0"
        const val init = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
    }
    object BuildToolsGradle {
        const val version = "7.0.4"
        const val init = "com.android.tools.build:gradle:$version"
    }

    object KotlinxSerialization {
        const val version = ProjectConfig.kotlinVersion
        const val init = "org.jetbrains.kotlin:kotlin-serialization:$version"
    }
}