package com.litao.lib.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class SoDependencyPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.task("soTest"){
            doLast {
                println("find .so file dependency")
            }
        }
    }
}
