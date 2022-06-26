package com.mufan.leetcode.model;

import lombok.Data;

@Data
public class Question {
  private String questionId;
  private String questionFrontendId;
  private String title;
  private String titleSlug;
  private String content;
  private String translatedTitle;
  private String translatedContent;
  private String difficulty;
}
