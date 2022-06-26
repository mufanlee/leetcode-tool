package com.mufan.leetcode.VO;

import lombok.Data;
import lombok.ToString;

@Data
public class Contest {
  private String id;
  private String title;
  private String titleSlug;
  @ToString.Exclude private String description;
  private Integer startTime;
}
