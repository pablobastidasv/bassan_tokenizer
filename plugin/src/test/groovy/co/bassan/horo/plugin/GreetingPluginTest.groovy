package co.bassan.horo.plugin

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

import static org.junit.Assert.assertTrue

/**
 * Test to check the added plugin works correctly
 */
class GreetingPluginTest {
    @Test
    public void bassanPluginAddsHelloTaskToProject() {
        Project project = ProjectBuilder.builder().build()
        project.apply plugin: 'co.bassan.tokenizer'
        println 'bassanPluginAddsHelloTaskToProject'
        assertTrue(project.tasks.hello instanceof HelloTask)
    }
}
