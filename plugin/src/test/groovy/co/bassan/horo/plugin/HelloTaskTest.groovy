package co.bassan.horo.plugin

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

import static org.junit.Assert.assertTrue

/**
 * Test to check if the adition of the task works fine
 */
class HelloTaskTest {
    @Test
    public void canAddTaskToProject() {
        Project project = ProjectBuilder.builder().build()
        def task = project.task('hello', type: HelloTask)
        assertTrue(task instanceof HelloTask)
    }
}
