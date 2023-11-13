
extra["PUBLISH_ARTIFACT_ID"] = "so-dependency-finder"

plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    `kotlin-dsl`
    `java-gradle-plugin`
    `maven-publish`
}


//val publish_plugin_path = "${rootProject.projectDir}/publish-to-maven.gradle-test.kts"
//if (File(publish_plugin_path).exists()) {

//}


//version = "1.0.2"
//group = "org.gradle.sample"
//
//publishing {
//    publications {
//        create<MavenPublication>("library") {
//            from(components["java"])
//        }
//    }
//    repositories {
//        maven {
//            url = uri(layout.buildDirectory.dir("publishing-repository"))
//        }
//    }
//}

//interface GreetingPluginExtension {
//    val message: Property<String>
//    val greeter: Property<String>
//}
//
//class GreetingPlugin : Plugin<Project> {
//    override fun apply(project: Project) {
//
//        val extension = project.extensions.create<GreetingPluginExtension>("greeting")
//        extension.message.convention("Hello from GreetingPlugin")
//        project.task("hello") {
//            doLast {
//                println("${extension.message.get()} from ${extension.greeter.get()}")
//            }
//        }
//    }
//}
//
//// Apply the plugin
//apply<GreetingPlugin>()
//
//// Configure the extension
////the<GreetingPluginExtension>().message = "Hi from Gradle"
//
//configure<GreetingPluginExtension> {
//    message = "H2i"
//    greeter = "Gradle"
//}


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
            id = "so-dependency_finder"
            implementationClass = "com.litao.lib.plugin.SoDependencyPlugin"
        }
    }
}



//abstract class GreetingToFileTask : DefaultTask() {
//
//    @get:OutputFile
//    abstract val destination: RegularFileProperty
//
//    @TaskAction
//    fun greet() {
//        val file = destination.get().asFile
//        file.parentFile.mkdirs()
//        file.writeText("Hello!")
//    }
//}
//
//val greetingFile = objects.fileProperty()
//
//tasks.register<GreetingToFileTask>("greet") {
//    destination = greetingFile
//}
//
//tasks.register("sayGreeting") {
//    dependsOn("greet")
//    val greetingFile = greetingFile
//    doLast {
//        val file = greetingFile.get().asFile
//        println("${file.readText()} (file: ${file.name})")
//    }
//}
//
//greetingFile = layout.buildDirectory.file("hello.txt")

apply(from = "../publish-to-maven.gradle.kts")