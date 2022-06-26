package com.mufan.leetcode.manager;

import com.mufan.leetcode.util.LeetCodeRequestUtils;
import com.mufan.leetcode.vo.ContestQuestion;
import com.mufan.leetcode.vo.WeeklyContest;

import java.util.Optional;

public final class WeeklyContestManager {
  private WeeklyContestManager() {}

  public static void generateNote(int weeklyContestId, String rootPath) {
    Optional<WeeklyContest> contest = LeetCodeRequestUtils.getWeeklyContestInfo(weeklyContestId);
    if (contest.isPresent()) {
      System.out.println(contest.get().getContest());
      for (ContestQuestion question : contest.get().getQuestions()) {
        QuestionManager.generateArticle(question.getTitleSlug(), rootPath + weeklyContestId + "\\");
      }
      return;
    }
    System.out.println("生成失败！");
  }
}
