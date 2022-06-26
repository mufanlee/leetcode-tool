package com.mufan.leetcode.manager;

import com.mufan.leetcode.model.Contest;
import com.mufan.leetcode.model.ContestQuestion;
import com.mufan.leetcode.model.WeeklyContest;
import com.mufan.leetcode.util.LeetCodeRequestUtils;

import java.util.Optional;

public final class WeeklyContestManager {
  private WeeklyContestManager() {}

  public static void generateNote(int weeklyContestId, String rootPath) {
    Optional<WeeklyContest> contest = LeetCodeRequestUtils.getWeeklyContestInfo(weeklyContestId);
    if (contest.isPresent()) {
      print(contest.get(), weeklyContestId);
      for (ContestQuestion question : contest.get().getQuestions()) {
        AnswerNoteManager.generateAnswerNote(
            question.getTitleSlug(), rootPath + weeklyContestId + "\\");
      }
      return;
    }
    System.out.println("第" + weeklyContestId + "场生成失败！");
  }

  private static void print(WeeklyContest weeklyContest, int id) {
    Contest contest = weeklyContest.getContest();
    System.out.println(contest.getTitle());
    System.out.println("[第" + id + "场](leetcode/weekly-contest/第" + id + "场.md)");
  }
}
