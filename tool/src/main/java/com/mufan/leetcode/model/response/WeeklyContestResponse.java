package com.mufan.leetcode.model.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Weekly Contest Response
 *
 * @author lipeng
 */
@NoArgsConstructor
@Data
public class WeeklyContestResponse {

    @JSONField(name = "contest")
    private Contest contest;
    @JSONField(name = "questions")
    private List<Questions> questions;
    @JSONField(name = "user_num")
    private Integer userNum;
    @JSONField(name = "has_chosen_contact")
    private Boolean hasChosenContact;
    @JSONField(name = "company")
    private Company company;
    @JSONField(name = "registered")
    private Boolean registered;
    @JSONField(name = "containsPremium")
    private Boolean containsPremium;

    @NoArgsConstructor
    @Data
    public static class Contest {
        @JSONField(name = "id")
        private Integer id;
        @JSONField(name = "title")
        private String title;
        @JSONField(name = "title_slug")
        private String titleSlug;
        @JSONField(name = "description")
        private String description;
        @JSONField(name = "duration")
        private Integer duration;
        @JSONField(name = "start_time")
        private Integer startTime;
        @JSONField(name = "is_virtual")
        private Boolean isVirtual;
        @JSONField(name = "origin_start_time")
        private Integer originStartTime;
        @JSONField(name = "is_private")
        private Boolean isPrivate;
        @JSONField(name = "related_contest_title")
        private Object relatedContestTitle;
        @JSONField(name = "is_ee_exam_contest")
        private Boolean isEeExamContest;
    }

    @NoArgsConstructor
    @Data
    public static class Company {
        @JSONField(name = "name")
        private String name;
        @JSONField(name = "description")
        private String description;
        @JSONField(name = "logo")
        private String logo;
        @JSONField(name = "slug")
        private String slug;
    }

    @NoArgsConstructor
    @Data
    public static class Questions {
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
}
