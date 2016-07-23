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
package co.bassan.plugins.tokenizer

import co.bassan.plugins.tokenizer.task.*
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Description and initialization of the tokenizer plugin
 */
class TokenizerPlugin implements Plugin<Project> {

    public static final VALIDATE_FILES_TASK_NAME = 'validateFiles'
    public static final VALIDATE_TOKENS_TASK_NAME = 'validateTokens'
    public static final LIST_TOKENS_TASK_NAME = 'listTokens'
    public static final APPLY_TOKENS_TASK_NAME = 'applyTokens'
    public static final LOAD_FILES = 'loadFiles'
    public static final EXTENSION_NAME = 'tokenizer'

    @Override
    void apply(Project project) {
        project.extensions.create(EXTENSION_NAME, TokenizerPluginExtension)

        project.task(LIST_TOKENS_TASK_NAME, type: ListTokensTask)
        project.task(VALIDATE_FILES_TASK_NAME, type: ValidateFilesTask)
        project.task(APPLY_TOKENS_TASK_NAME, type: ApplyTokenToFilesTask)
        project.task(VALIDATE_TOKENS_TASK_NAME, type: ValidateTokensTask)
        project.task(LOAD_FILES, type: LoadFilesTask)
    }
}
