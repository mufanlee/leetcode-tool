package com.mufan.leetcode.manager;

import com.mufan.leetcode.model.AnswerNote;
import com.mufan.leetcode.model.Question;
import com.mufan.leetcode.util.FileUtils;
import com.mufan.leetcode.util.LeetCodeRequestUtils;
import io.github.furstenheim.CopyDown;
import io.github.furstenheim.Options;
import io.github.furstenheim.OptionsBuilder;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public final class QuestionManager {
  private QuestionManager() {}

  public static void generateArticle(String articleSlug, String path) {
    Question question = LeetCodeRequestUtils.getCnQuestion(articleSlug);
    if (Objects.isNull(question)) {
      System.out.println(articleSlug + "：请求失败！");
      return;
    }

    AnswerNote note =
        AnswerNote.builder()
            .id(question.getQuestionFrontendId())
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
}
