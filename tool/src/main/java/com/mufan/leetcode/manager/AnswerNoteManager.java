package com.mufan.leetcode.manager;

import cn.hutool.core.collection.CollectionUtil;
import com.mufan.leetcode.model.CodeSnippet;
import com.mufan.leetcode.converter.QuestionToAnswerNoteConverter;
import com.mufan.leetcode.enums.CodeLang;
import com.mufan.leetcode.model.AnswerNote;
import com.mufan.leetcode.model.Question;
import com.mufan.leetcode.util.LeetCodeRequestUtils;
import com.mufan.leetcode.util.TemplateUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author lipeng
 */
public final class AnswerNoteManager {
  private AnswerNoteManager() {}

  public static void generateAnswerNote(String questionSlug, String path) {
    Question question = LeetCodeRequestUtils.getCnQuestion(questionSlug);
    if (Objects.isNull(question)) {
      System.out.println(questionSlug + "：请求失败！");
      return;
    }

    AnswerNote note = QuestionToAnswerNoteConverter.INSTANCE.convert(question);
    String noteStr =
        TemplateUtils.render(
            "templates/answer-note-template.stg", "answerNoteTemplate", "answerNote", note);
    System.out.println(noteStr);
//    String name = question.getQuestionFrontendId() + ". " + question.getTranslatedTitle();
//    System.out.println("[" + name + "](leetcode/" + getFileName(question) + ")");
//    FileUtils.saveFile(path + getFileName(question), note.toString());
  }

  private static String getFileName(Question question) {
    String title = question.getTranslatedTitle().replaceAll(" ", "");
    return question.getQuestionFrontendId() + title + ".md";
  }

  private static String getCodeSnippet(List<CodeSnippet> codeSnippets, CodeLang lang) {
    List<CodeSnippet> snippets =
        codeSnippets.stream()
            .filter(code -> code.getLang().equals(lang.getValue()))
            .collect(Collectors.toList());
    return CollectionUtil.isEmpty(snippets) ? StringUtils.EMPTY : snippets.get(0).getCode();
  }
}
