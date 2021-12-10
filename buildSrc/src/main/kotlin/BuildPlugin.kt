/**
 * @Author: maksonic on 08.12.2021
 */
object BuildPlugin {
    const val kotlinGradleVersion = "1.6.0"

    object BuildToolsGradle {
        private const val version = "7.0.3"
        const val init = "com.android.tools.build:gradle:$version"
    }

    object KotlinxSerialization {
        private const val version = ProjectConfig.kotlinVersion
        const val init = "org.jetbrains.kotlin:kotlin-serialization:$version"
    }


}