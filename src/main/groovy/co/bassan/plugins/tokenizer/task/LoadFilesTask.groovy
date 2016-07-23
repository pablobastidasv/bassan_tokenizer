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

import co.bassan.plugins.tokenizer.TokenizerPlugin
import co.bassan.plugins.tokenizer.TokenizerPluginExtension
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

import static groovy.io.FileType.FILES

/**
 * This task load all the files that could be tokenize and
 * stored in a list
 */
class LoadFilesTask extends DefaultTask{

    @TaskAction
    void start(){
        TokenizerPluginExtension extension = project.extensions.findByName(TokenizerPlugin.EXTENSION_NAME) as TokenizerPluginExtension

        if(!extension.files){
            extension.files = new ArrayList<>()
        }

        logger.quiet "Files to tokenize:"
        new File("./").eachFileRecurse(FILES) {
            if(it.name.matches(extension.fileFilter)) {
                extension.files.add(it.path);

                logger.quiet "\t- ${it.path}"
            }
        }
    }

}
