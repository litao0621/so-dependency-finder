package com.litao.lib.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.provider.Property
import org.gradle.kotlin.dsl.create

interface DependencyPluginExtension {
    val message: Property<String>
}

class SoDependencyPlugin : Plugin<Project> {
    override fun apply(target: Project) {

        val extension = target.extensions.create<DependencyPluginExtension>("finder")
        extension.message.convention("im from soDependencyFinder")

        target.task("soDependencyFinder"){
            doLast {
                println(extension.message.get())
            }
        }
    }
}
