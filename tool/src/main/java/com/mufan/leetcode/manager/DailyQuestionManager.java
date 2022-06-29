package com.mufan.leetcode.manager;

import cn.hutool.core.date.DateUtil;
import com.mufan.leetcode.constant.Constant;
import com.mufan.leetcode.enums.CodeLang;
import com.mufan.leetcode.util.LeetCodeRequestUtils;

/**
 * @author lipeng
 */
public final class DailyQuestionManager {
  private DailyQuestionManager() {}

  public static void generateNote(String rootPath) {
    System.out.println(DateUtil.today() + " 每日一题：");
    LeetCodeRequestUtils.getDailyQuestion()
        .ifPresent(
            question -> {
              String time = DateUtil.today().replaceAll("-", "");
              AnswerNoteManager.generateAnswerNote(
                  question.getTitleSlug(), rootPath + "\\daily\\d" + time + "\\");
              CodeManager.generateCode(
                  question.getTitleSlug(), rootPath + "\\daily\\d" + time + "\\", CodeLang.JAVA);
            });
  }

  public static void main(String[] args) {
    DailyQuestionManager.generateNote(Constant.CODING_PATH);
  }
}
