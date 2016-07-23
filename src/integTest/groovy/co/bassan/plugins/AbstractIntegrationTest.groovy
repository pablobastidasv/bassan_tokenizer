/**
 * The MIT License (MIT)
 * Copyright (c) 2016 Pablo Bastidas
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is furnished
 * to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE
 * OR OTHER DEALINGS IN THE SOFTWARE.
 */
package co.bassan.plugins

import org.gradle.testkit.runner.GradleRunner
import org.junit.Rule
import org.junit.rules.TemporaryFolder
import spock.lang.Specification

import static org.gradle.testkit.runner.GradleRunner.create

abstract class AbstractIntegrationTest extends Specification{
    @Rule
    final TemporaryFolder temporaryFolder = new TemporaryFolder()

    File projectDir
    File buildFile
    File propertiesFile
    List pluginClasspath

    def setup() {
        projectDir = temporaryFolder.root
        buildFile = temporaryFolder.newFile 'build.gradle'
        propertiesFile = temporaryFolder.newFile('gradle.properties')

        pluginClasspath = getClass().classLoader.getResource("plugin-classpath.txt").readLines().collect { new File(it) }

        buildFile << """
            plugins {
                id 'co.bassan.tokenizer'
            }

            repositories {
                mavenCentral()
            }

            tokenizer.url = 'www.bassan.co'
        """
    }

    protected GradleRunner buildProject(String argument) {
        create().withProjectDir(projectDir).
                withPluginClasspath(pluginClasspath).
                withArguments(argument)
    }
}
