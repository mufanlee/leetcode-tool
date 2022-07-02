package com.mufan.leetcode.manager;

import cn.hutool.log.Log;
import com.mufan.leetcode.converter.QuestionToAnswerNoteConverter;
import com.mufan.leetcode.helper.LeetCodeQuestionHelper;
import com.mufan.leetcode.model.AnswerNote;
import com.mufan.leetcode.model.Question;
import com.mufan.leetcode.util.FileUtils;
import com.mufan.leetcode.util.TemplateUtils;

import java.util.Optional;

/**
 * AnswerNote Manager
 *
 * @author lipeng
 */
public final class AnswerNoteManager {
    private static final Log LOG = Log.get();
    public static final String ANSWER_NOTE_STG = "templates/answer-note-template.stg";
    public static final String TEMPLATE_NAME = "answerNoteTemplate";

    private AnswerNoteManager() {
    }

    public static void generateNote(String questionSlug, String path) {
        Optional<Question> question = LeetCodeQuestionHelper.getQuestion(questionSlug);
        if (!question.isPresent()) {
            LOG.error("Question [{}] request failed!", questionSlug);
            return;
        }

        AnswerNote note = QuestionToAnswerNoteConverter.INSTANCE.convert(question.get());
        String fileName = question.get().getShortCnName() + ".md";
        LOG.info("[{}](leetcode/{})", question.get().getFullCnName(), fileName);
        FileUtils.saveFile(path + fileName,
                TemplateUtils.render(ANSWER_NOTE_STG, TEMPLATE_NAME, "answerNote", note));
    }
}
