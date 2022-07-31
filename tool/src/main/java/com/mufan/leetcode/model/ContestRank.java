package com.mufan.leetcode.model;

import lombok.Data;

import java.util.List;

/**
 * Weekly Contest Rank
 *
 * @author lipeng
 */
@Data
public class ContestRank {
    private List<UserRank> totalRank;
    private Integer userNum;
}
