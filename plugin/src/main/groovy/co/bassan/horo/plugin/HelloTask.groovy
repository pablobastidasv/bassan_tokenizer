package co.bassan.horo.plugin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * This class create a task, this just show a simple message
 */
class HelloTask extends DefaultTask{

    @TaskAction
    def void showMessage(){
        println "---------- Message ------------"
        println "${project.greeting.message} from ${project.greeting.greeter}"
        println "---------- Message ------------"
    }

}
