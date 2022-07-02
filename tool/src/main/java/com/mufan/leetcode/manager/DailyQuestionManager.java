package com.mufan.leetcode.manager;

import cn.hutool.core.date.DateUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.mufan.leetcode.constant.Constant;
import com.mufan.leetcode.enums.CodeLang;
import com.mufan.leetcode.helper.LeetCodeDailyQuestionHelper;
import com.mufan.leetcode.model.DailyQuestion;

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
        String filePath = rootPath + "\\daily\\d" + time + "\\";
        AnswerNoteManager.generateNote(question.getTitleSlug(), filePath);
        CodeManager.generateCode(question.getTitleSlug(), filePath, CodeLang.JAVA);
    }

    public static void main(String[] args) {
        DailyQuestionManager.generateNote(Constant.CODING_PATH);
    }
}
