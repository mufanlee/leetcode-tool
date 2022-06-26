package com.mufan.leetcode.VO;

import lombok.Data;

import java.util.List;

@Data
public class WeeklyContest {
  private Contest contest;
  private List<Question> questions;
  private Integer userNum;
}
