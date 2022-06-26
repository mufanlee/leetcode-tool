package com.mufan.leetcode;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson2.JSONObject;
import com.mufan.leetcode.model.AnswerNote;
import com.mufan.leetcode.model.MyHttpRequest;
import com.mufan.leetcode.model.MyHttpResponse;
import com.mufan.leetcode.model.Question;
import com.mufan.leetcode.util.FileUtils;
import com.mufan.leetcode.util.HttpRequestUtils;
import io.github.furstenheim.CopyDown;
import io.github.furstenheim.Options;
import io.github.furstenheim.OptionsBuilder;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class ArticleManager {
  public static void generateArticle(String articleSlug, String path) {
    Question question = getCnArticle(articleSlug);
    if (Objects.isNull(question)) {
      System.out.println(articleSlug + "：请求失败！");
      return;
    }

    AnswerNote note =
        AnswerNote.builder()
            .id(question.getQuestionId())
            .title(question.getTranslatedTitle())
            .slug(question.getTitleSlug())
            .question(formatMarkdown(question.getTranslatedContent()))
            .build();
    System.out.println(
        question.getQuestionFrontendId() + "." + question.getTranslatedTitle() + " 请求成功！");
    FileUtils.saveFile(path + getFileName(question), note.toString());
  }

  private static String getFileName(Question question) {
    String title = question.getTranslatedTitle().replaceAll(" ", "");
    return question.getQuestionFrontendId() + title + ".md";
  }

  private static String formatMarkdown(String content) {
    if (Objects.isNull(content)) {
      return StringUtils.EMPTY;
    }
    Options options = OptionsBuilder.anOptions().withBr("-").build();
    CopyDown copyDown = new CopyDown(options);
    return copyDown.convert(content);
  }

  private static Question getCnArticle(String articleSlug) {
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

  private static String getEnArticle(String articleSlug) {
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
