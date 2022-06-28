package com.mufan.leetcode.manager;

import com.mufan.leetcode.constant.Constant;
import com.mufan.leetcode.enums.CodeLang;
import com.mufan.leetcode.model.CodeSnippet;
import com.mufan.leetcode.model.Question;
import com.mufan.leetcode.util.FileUtils;
import com.mufan.leetcode.util.LeetCodeRequestUtils;

import java.util.Objects;

/**
 * @author lipeng
 */
public final class CodeManager {
  private CodeManager() {}

  public static void generateCode(String questionSlug, String rootPath, CodeLang lang) {
    Question question = LeetCodeRequestUtils.getCnQuestion(questionSlug);
    if (Objects.isNull(question)) {
      System.out.println(questionSlug + "：请求失败！");
      return;
    }

    question.getCodeSnippets().stream()
        .filter(snippet -> Objects.equals(snippet.getLang(), lang.getValue()))
        .map(CodeSnippet::getCode)
        .findAny()
        .ifPresent(code -> FileUtils.saveFile(rootPath + "Solution.java", code));
  }

  public static void main(String[] args) {
    CodeManager.generateCode("check-if-matrix-is-x-matrix", Constant.CODING_PATH, CodeLang.JAVA);
  }
}
