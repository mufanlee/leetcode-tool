package com.mufan.leetcode.model;

import com.mufan.leetcode.enums.Difficulty;
import lombok.Data;

/**
 * DailyQuestion
 *
 * @author lipeng
 */
@Data
public class DailyQuestion {
    private String questionId;
    private String frontendQuestionId;
    private Difficulty difficulty;
    private String title;
    private String titleCn;
    private String titleSlug;
    private Double acRate;
    private Integer solutionNum;
}
