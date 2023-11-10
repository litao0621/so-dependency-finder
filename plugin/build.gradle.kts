
extra["PUBLISH_ARTIFACT_ID"] = "so-dependency-finder"

plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    `kotlin-dsl`
    `java-gradle-plugin`
}

val publish_plugin_path = "${rootProject.projectDir}/publish-to-maven-test.gradle.kts"
if (File(publish_plugin_path).exists()) {
    apply(from = publish_plugin_path)
}




java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly("com.android.tools.build:gradle:8.1.2")
    compileOnly("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.10")
    compileOnly("com.google.devtools.ksp:com.google.devtools.ksp.gradle.plugin:1.9.10-1.0.13")
}



gradlePlugin {
    plugins {
        create("SoDependencyFinder") {
            id = "io.github.litao0621.plugin"
            implementationClass = "com.litao.lib.plugin.SoDependencyPlugin"
        }
    }
}