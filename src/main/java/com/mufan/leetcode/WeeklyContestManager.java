package com.mufan.leetcode;

import cn.hutool.http.HttpStatus;
import cn.hutool.json.JSONUtil;
import com.mufan.leetcode.VO.Question;
import com.mufan.leetcode.VO.WeeklyContest;
import com.mufan.leetcode.model.MyHttpRequest;
import com.mufan.leetcode.model.MyHttpResponse;
import com.mufan.leetcode.util.HttpRequestUtils;
import com.mufan.leetcode.util.LeetCodeUrlUtils;

import java.util.Optional;

public class WeeklyContestManager {
  public static void generateNote(int weeklyContestId, String rootPath) {
    Optional<WeeklyContest> contest = WeeklyContestManager.getQuestions(weeklyContestId);
    if (contest.isPresent()) {
      System.out.println(contest.get().getContest());
      for (Question question : contest.get().getQuestions()) {
        ArticleManager.generateArticle(question.getTitleSlug(), rootPath + weeklyContestId + "\\");
      }
      return;
    }
    System.out.println("生成失败！");
  }

  public static Optional<WeeklyContest> getQuestions(int id) {
    MyHttpRequest request = MyHttpRequest.get(LeetCodeUrlUtils.weeklyContestUrl(id));
    MyHttpResponse response = HttpRequestUtils.executeGet(request);
    if (response.getStatusCode() == HttpStatus.HTTP_OK) {
      WeeklyContest contest = JSONUtil.toBean(response.getBody(), WeeklyContest.class);
      System.out.println(contest.getContest().getTitle());
      return Optional.of(contest);
    }
    return Optional.empty();
  }
}
