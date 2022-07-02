package com.mufan.leetcode.model;

import lombok.Data;

/**
 * Contest Question
 *
 * @author lipeng
 */
@Data
public class ContestQuestion {
  private String id;
  private String questionId;
  private Integer credit;
  private String title;
  private String englishTitle;
  private String titleSlug;
  private String categorySlug;
}
