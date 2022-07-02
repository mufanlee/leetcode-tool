package com.mufan.leetcode.model;

import lombok.Data;
import lombok.ToString;

/**
 * Contest
 *
 * @author lipeng
 */
@Data
public class Contest {
    private String id;
    private String title;
    private String titleSlug;
    @ToString.Exclude
    private String description;
    private Integer startTime;
}
