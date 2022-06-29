package com.mufan.leetcode.model;

import lombok.Data;

@Data
public class ContestQuestion {
  private String id;
  private String questionId;
  private String title;
  private Integer credit;
  private String englishTitle;
  private String titleSlug;
}
