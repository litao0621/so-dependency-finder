pluginManagement {
    repositories {
        maven {
            url = uri("./plugin/build/publishing-repository")
        }
        google()
        mavenCentral()
        gradlePluginPortal()
    }

}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "SoDependency"
include(":app")
include(":plugin")
