package com.mufan.leetcode.manager;

import cn.hutool.core.date.DateUtil;
import com.mufan.leetcode.constant.Constant;
import com.mufan.leetcode.util.LeetCodeRequestUtils;

/**
 * @author lipeng
 */
public final class DailyQuestionManager {
  private DailyQuestionManager() {}

  public static void generateNote(String rootPath) {
    System.out.println(DateUtil.today());
    LeetCodeRequestUtils.getDailyQuestion()
        .ifPresent(
            question ->
                AnswerNoteManager.generateAnswerNote(
                    question.getTitleSlug(), rootPath + "\\daily\\"));
  }

  public static void main(String[] args) {
    DailyQuestionManager.generateNote(Constant.ROOT_PATH);
  }
}
