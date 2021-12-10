dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Numbers"
include (":app")
include(":core")
include(":data")
include(":domain")
include(":presentation:main-screen")
include(":presentation:about-screen")

