package com.mufan.leetcode.manager;

import com.mufan.leetcode.model.ContestQuestion;
import com.mufan.leetcode.model.WeeklyContest;
import com.mufan.leetcode.util.LeetCodeRequestUtils;

import java.util.Optional;

public final class WeeklyContestManager {
  private WeeklyContestManager() {}

  public static void generateNote(int weeklyContestId, String rootPath) {
    Optional<WeeklyContest> contest = LeetCodeRequestUtils.getWeeklyContestInfo(weeklyContestId);
    if (contest.isPresent()) {
      System.out.println(contest.get().getContest());
      for (ContestQuestion question : contest.get().getQuestions()) {
        AnswerNoteManager.generateAnswerNote(
            question.getTitleSlug(), rootPath + weeklyContestId + "\\");
      }
      return;
    }
    System.out.println("生成失败！");
  }
}
