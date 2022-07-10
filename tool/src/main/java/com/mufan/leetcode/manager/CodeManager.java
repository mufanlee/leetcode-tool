package com.mufan.leetcode.manager;

import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.log.Log;
import com.mufan.leetcode.enums.CodeLang;
import com.mufan.leetcode.helper.LeetCodePlaygroundHelper;
import com.mufan.leetcode.helper.LeetCodeQuestionHelper;
import com.mufan.leetcode.manager.code.DefaultCodeFileFactory;
import com.mufan.leetcode.model.Question;
import com.mufan.leetcode.util.FileUtils;

import java.util.Optional;

/**
 * Code Manager
 *
 * @author lipeng
 */
public final class CodeManager {
    private static final Log LOG = Log.get();

    private CodeManager() {
    }

    public static void generateCode(String questionSlug, String rootPath, CodeLang lang) {
        Optional<Question> question = LeetCodeQuestionHelper.getQuestion(questionSlug);
        if (!question.isPresent()) {
            LOG.error("Question [{}] request failed!", questionSlug);
            return;
        }

        LOG.info("Generate {} Code.", question.get().getFullCnName());
        question.get().getCodeSnippets().stream()
                .filter(snippet -> CharSequenceUtil.equalsIgnoreCase(snippet.getLangSlug(), lang.getSlug()))
                .map(snippet -> DefaultCodeFileFactory.getInstance()
                        .getCodeFile(CodeLang.getEnum(snippet.getLangSlug()), snippet.getCode()))
                .findAny()
                .ifPresent(codeFile -> {
                    String mainClass
                            = LeetCodePlaygroundHelper.getMainClass(question.get().getQuestionFrontendId(), lang);
                    FileUtils.saveFile(rootPath + codeFile.getFileName(), codeFile.getCode() + mainClass);
                });
    }

    public static void generateCodes(String questionSlug, String rootPath) {
        Optional<Question> question = LeetCodeQuestionHelper.getQuestion(questionSlug);
        if (!question.isPresent()) {
            LOG.error("Question [{}] request failed!", questionSlug);
            return;
        }

        question.get().getCodeSnippets().stream()
                .map(snippet -> DefaultCodeFileFactory.getInstance()
                        .getCodeFile(CodeLang.getEnum(snippet.getLangSlug()), snippet.getCode()))
                .forEach(codeFile -> FileUtils.saveFile(rootPath + codeFile.getFileName(), codeFile.getCode()));
    }
}
