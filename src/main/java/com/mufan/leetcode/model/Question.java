package com.mufan.leetcode.model;

import lombok.Data;

import java.util.List;

@Data
public class Question {
  private String questionId;
  private String questionFrontendId;
  private String categoryTitle;
  private String title;
  private String titleSlug;
  private String content;
  private String translatedTitle;
  private String translatedContent;
  private String difficulty;
  private String similarQuestions;
  private List<CodeSnippet> codeSnippets;
  private List<TopicTag> topicTags;
  private List<String> hints;
  private String exampleTestcases;
}
