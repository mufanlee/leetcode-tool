package com.mufan.leetcode.util;

import cn.hutool.http.HttpStatus;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson2.JSONObject;
import com.mufan.leetcode.model.MyHttpRequest;
import com.mufan.leetcode.model.MyHttpResponse;
import com.mufan.leetcode.model.Question;
import com.mufan.leetcode.model.WeeklyContest;

import java.util.Optional;

public final class LeetCodeRequestUtils {
  private LeetCodeRequestUtils() {}

  private static String weeklyContestUrl(int id) {
    return "https://leetcode.cn/contest/api/info/weekly-contest-" + id + "/";
  }

  public static Optional<WeeklyContest> getWeeklyContestInfo(int id) {
    MyHttpRequest request = MyHttpRequest.get(weeklyContestUrl(id));
    MyHttpResponse response = HttpRequestUtils.executeGet(request);
    if (response.getStatusCode() == HttpStatus.HTTP_OK) {
      WeeklyContest contest = JSONUtil.toBean(response.getBody(), WeeklyContest.class);
      System.out.println(contest.getContest().getTitle());
      return Optional.of(contest);
    }
    return Optional.empty();
  }

  public static Question getCnQuestion(String articleSlug) {
    try {
      MyHttpRequest request =
          MyHttpRequest.post("https://leetcode.cn/graphql/", "application/json");
      String body =
          "{\n"
              + "  \"operationName\": \"questionData\",\n"
              + "  \"variables\": {\n"
              + "    \"titleSlug\": \""
              + articleSlug
              + "\"\n"
              + "  },\n"
              + "  \"query\": \"query questionData($titleSlug: String!) {\\n  question(titleSlug: $titleSlug) {\\n    questionId\\n    questionFrontendId\\n    categoryTitle\\n    boundTopicId\\n    title\\n    titleSlug\\n    content\\n    translatedTitle\\n    translatedContent\\n    isPaidOnly\\n    difficulty\\n    likes\\n    dislikes\\n    isLiked\\n    similarQuestions\\n    contributors {\\n      username\\n      profileUrl\\n      avatarUrl\\n      __typename\\n    }\\n    langToValidPlayground\\n    topicTags {\\n      name\\n      slug\\n      translatedName\\n      __typename\\n    }\\n    companyTagStats\\n    codeSnippets {\\n      lang\\n      langSlug\\n      code\\n      __typename\\n    }\\n    stats\\n    hints\\n    solution {\\n      id\\n      canSeeDetail\\n      __typename\\n    }\\n    status\\n    sampleTestCase\\n    metaData\\n    judgerAvailable\\n    judgeType\\n    mysqlSchemas\\n    enableRunCode\\n    envInfo\\n    book {\\n      id\\n      bookName\\n      pressName\\n      source\\n      shortDescription\\n      fullDescription\\n      bookImgUrl\\n      pressImgUrl\\n      productUrl\\n      __typename\\n    }\\n    isSubscribed\\n    isDailyQuestion\\n    dailyRecordStatus\\n    editorType\\n    ugcQuestionId\\n    style\\n    exampleTestcases\\n    jsonExampleTestcases\\n    __typename\\n  }\\n}\\n\"\n"
              + "}";
      request.setBody(body);
      MyHttpResponse response = HttpRequestUtils.executePost(request);
      if (response.getStatusCode() == 200) {
        JSONObject questionJsonObject =
            JSONObject.parseObject(response.getBody())
                .getJSONObject("data")
                .getJSONObject("question");
        return JSONUtil.toBean(questionJsonObject.toJSONString(), Question.class);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  public static String getEnQuestion(String articleSlug) {
    try {
      MyHttpRequest httpRequest =
          MyHttpRequest.post("https://leetcode.cn/graphql/", "application/json");
      String body =
          "{\n"
              + "  \"operationName\": \"questionData\",\n"
              + "  \"variables\": {\n"
              + "    \"titleSlug\": \""
              + articleSlug
              + "\"\n"
              + "  },\n"
              + "  \"query\": \"query questionData($titleSlug: String!) {\\n  question(titleSlug: $titleSlug) {\\n    questionId\\n    questionFrontendId\\n    categoryTitle\\n    boundTopicId\\n    title\\n    titleSlug\\n    content\\n    translatedTitle\\n    translatedContent\\n    isPaidOnly\\n    difficulty\\n    likes\\n    dislikes\\n    isLiked\\n    similarQuestions\\n    contributors {\\n      username\\n      profileUrl\\n      avatarUrl\\n      __typename\\n    }\\n    langToValidPlayground\\n    topicTags {\\n      name\\n      slug\\n      translatedName\\n      __typename\\n    }\\n    companyTagStats\\n    codeSnippets {\\n      lang\\n      langSlug\\n      code\\n      __typename\\n    }\\n    stats\\n    hints\\n    solution {\\n      id\\n      canSeeDetail\\n      __typename\\n    }\\n    status\\n    sampleTestCase\\n    metaData\\n    judgerAvailable\\n    judgeType\\n    mysqlSchemas\\n    enableRunCode\\n    envInfo\\n    book {\\n      id\\n      bookName\\n      pressName\\n      source\\n      shortDescription\\n      fullDescription\\n      bookImgUrl\\n      pressImgUrl\\n      productUrl\\n      __typename\\n    }\\n    isSubscribed\\n    isDailyQuestion\\n    dailyRecordStatus\\n    editorType\\n    ugcQuestionId\\n    style\\n    exampleTestcases\\n    jsonExampleTestcases\\n    __typename\\n  }\\n}\\n\"\n"
              + "}";
      httpRequest.setBody(body);
      MyHttpResponse response = HttpRequestUtils.executePost(httpRequest);
      if (response.getStatusCode() == 200) {
        return JSONObject.parseObject(response.getBody())
            .getJSONObject("data")
            .getJSONObject("question")
            .getString("content");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
