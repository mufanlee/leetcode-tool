package com.mufan.leetcode.model;

import lombok.Data;

/**
 * User Rank
 *
 * @author lipeng
 */
@Data
public class UserRank {
    private Integer contestId;
    private String username;
    private String userSlug;
    private String realName;
    private String countryCode;
    private String countryName;
    private Integer rank;
    private Integer score;
    private Integer finishTime;
    private Integer globalRanking;
    private String dataRegion;
    private String avatarUrl;
    private Integer rankV2;
}
