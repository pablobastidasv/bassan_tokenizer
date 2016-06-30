package co.bassan.horo.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Main plugin file, this define where is the information from the
 * build.gradle file and add tasks
 */
class GreetingPlugin implements Plugin<Project> {

    void apply(Project project) {
        project.extensions.create("greeting", GreetingPluginExtension)
        project.task('hello', type: HelloTask)
    }

}