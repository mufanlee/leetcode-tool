package com.mufan.leetcode.model.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Weekly Contest Rank
 *
 * @author lipeng
 */
@Data
@NoArgsConstructor
public class RankResponse {
    @JSONField(name = "is_past")
    private Boolean isPast;
    @JSONField(name = "submissions")
    private List<Object> submissions;
    @JSONField(name = "questions")
    private List<Question> questions;
    @JSONField(name = "total_rank")
    private List<UserRank> totalRank;
    @JSONField(name = "user_num")
    private Integer userNum;

    @NoArgsConstructor
    @Data
    public static class Question {
        @JSONField(name = "id")
        private Integer id;
        @JSONField(name = "question_id")
        private Integer questionId;
        @JSONField(name = "credit")
        private Integer credit;
        @JSONField(name = "title")
        private String title;
        @JSONField(name = "english_title")
        private String englishTitle;
        @JSONField(name = "title_slug")
        private String titleSlug;
        @JSONField(name = "category_slug")
        private String categorySlug;
    }

    @NoArgsConstructor
    @Data
    public static class UserRank {
        @JSONField(name = "contest_id")
        private Integer contestId;
        @JSONField(name = "username")
        private String username;
        @JSONField(name = "user_slug")
        private String userSlug;
        @JSONField(name = "real_name")
        private String realName;
        @JSONField(name = "country_code")
        private String countryCode;
        @JSONField(name = "country_name")
        private String countryName;
        @JSONField(name = "rank")
        private Integer rank;
        @JSONField(name = "score")
        private Integer score;
        @JSONField(name = "finish_time")
        private Integer finishTime;
        @JSONField(name = "global_ranking")
        private Integer globalRanking;
        @JSONField(name = "data_region")
        private String dataRegion;
        @JSONField(name = "avatar_url")
        private String avatarUrl;
        @JSONField(name = "rank_v2")
        private Integer rankV2;
    }
}
