package com.mufan.leetcode.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
@AllArgsConstructor
public class AnswerNote {
  private String id;
  private String title;
  private String slug;
  private String question;

  private String code;

  @Override
  public String toString() {
    return "# "
        + "["
        + id
        + ". "
        + title
        + "]("
        + "https://leetcode.cn/problems/"
        + slug
        + "/"
        + ")"
        + "\n"
        + "\n"
        + "### 题目\n"
        + "\n"
        + question
        + "\n"
        + "\n"
        + "### 解题思路\n"
        + "\n"
        + "#### 方法：\n"
        + "\n"
        + "##### 复杂度分析\n"
        + "\n"
        + "- 时间复杂度：$O(n)$。\n"
        + "- 空间复杂度：$O(n)$。\n"
        + "\n"
        + "### 代码\n"
        + "\n"
        + "```java\n"
        + code
        + "\n"
        + "```";
  }
}
