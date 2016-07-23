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
package co.bassan.plugins.tokenizer.task

import co.bassan.plugins.AbstractIntegrationTest
import co.bassan.plugins.tokenizer.TokenizerPlugin
import org.gradle.testkit.runner.BuildResult

class LoadFilesTaskTest extends AbstractIntegrationTest {

    def setup(){
        buildFile << """
            import co.bassan.plugins.tokenizer.task.LoadFilesTask

            task loadFilesTaskTest(type: LoadFilesTask)
        """
    }

    def "Loaded files from resources when Load files is executed"(){
        when:
        BuildResult result = buildProject("loadFilesTaskTest").build() as BuildResult

        then:
        result.task(":loadFilesTaskTest").outcome.toString() == 'SUCCESS'
        result.output.contains("jdbc.properties")
        !result.output.contains("log4j.xml")
    }

    def "Loaded files from resources when Load files is executed and its fileFilter is changed"(){
        given:
        buildFile << """
            ${TokenizerPlugin.EXTENSION_NAME}.fileFilter = /(.*?)\\.(properties|xml)\$/
        """

        when:
        BuildResult result = buildProject("loadFilesTaskTest").build() as BuildResult

        then:
        result.task(":loadFilesTaskTest").outcome.toString() == 'SUCCESS'
        result.output.contains("jdbc.properties")
        result.output.contains("log4j.xml")
    }
}
