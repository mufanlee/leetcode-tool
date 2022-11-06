package com.mufan.leetcode.manager;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.text.StrPool;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.mufan.leetcode.enums.CodeLang;
import com.mufan.leetcode.helper.LeetCodeDailyQuestionHelper;
import com.mufan.leetcode.helper.LeetCodeQuestionHelper;
import com.mufan.leetcode.model.DailyQuestion;
import com.mufan.leetcode.model.Question;
import com.mufan.leetcode.util.PropUtils;

import java.util.Optional;

/**
 * @author lipeng
 */
public final class DailyQuestionManager {
    private static final Log LOG = LogFactory.get();

    private DailyQuestionManager() {
    }

    public static void generateNote(String rootPath) {
        Optional<DailyQuestion> dailyQuestion = LeetCodeDailyQuestionHelper.getDailyQuestion();
        if (!dailyQuestion.isPresent()) {
            LOG.error("Daily Question request failed!");
            return;
        }

        DailyQuestion question = dailyQuestion.get();
        LOG.info("{} daily question: {}", DateUtil.today(), question.getTitleCn());
        String time = DateUtil.format(DateUtil.date(), "yyyyMMdd");
        String filePath = rootPath + "/daily/dd" + time + StrPool.SLASH;
        AnswerNoteManager.generateNote(question.getTitleSlug(), filePath);
        CodeManager.generateCode(question.getTitleSlug(), filePath, CodeLang.JAVA);
    }

    public static void generateNote(String questionSlug, String time, String rootPath) {
        Optional<Question> dailyQuestion = LeetCodeQuestionHelper.getQuestion(questionSlug);
        if (!dailyQuestion.isPresent()) {
            LOG.error("Daily Question request failed!");
            return;
        }

        Question question = dailyQuestion.get();
        LOG.info("{} daily question: {}", DateUtil.today(), question.getTranslatedTitle());
        String filePath = rootPath + "/daily/dd" + time + StrPool.SLASH;
        AnswerNoteManager.generateNote(question.getTitleSlug(), filePath);
        CodeManager.generateCode(question.getTitleSlug(), filePath, CodeLang.JAVA);
    }

    public static void main(String[] args) {
        String path = PropUtils.getStr("configs/config.properties", "code-path");
        DailyQuestionManager.generateNote(path);
//        DailyQuestionManager.generateNote("numbers-at-most-n-given-digit-set", "20221018", path);
    }
}
