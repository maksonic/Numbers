/**
 * @Author: maksonic on 08.12.2021
 */
object Module {
    const val app = ":app"
    const val core = ":core"
    const val domain = ":domain"
    const val data = ":data"

    object Screen {
        const val main = ":presentation:main-screen"
        const val about = ":presentation:about-screen"
    }

    object Navigation {
        const val api = ":navigation:api"
        const val impl = ":navigation:impl"
    }
}
