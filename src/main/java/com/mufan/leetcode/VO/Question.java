package com.mufan.leetcode.VO;

import lombok.Data;

@Data
public class Question {
  private String id;
  private String questionId;
  private String title;
  private Integer credit;
  private String englishTitle;
  private String titleSlug;
}
