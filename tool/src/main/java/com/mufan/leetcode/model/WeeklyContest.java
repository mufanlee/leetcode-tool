package com.mufan.leetcode.model;

import lombok.Data;

import java.util.List;

/**
 * Weekly Contest
 *
 * @author lipeng
 */
@Data
public class WeeklyContest {
    private Contest contest;
    private List<ContestQuestion> questions;
    private Integer userNum;
}
