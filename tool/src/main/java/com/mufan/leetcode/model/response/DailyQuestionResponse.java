package com.mufan.leetcode.model.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Daily Question Response
 *
 * @author lipeng
 */
@NoArgsConstructor
@Data
public class DailyQuestionResponse {

    @JSONField(name = "data")
    private Data data;

    @NoArgsConstructor
    @lombok.Data
    public static class Data {
        @JSONField(name = "todayRecord")
        private List<TodayRecord> todayRecord;

        @NoArgsConstructor
        @lombok.Data
        public static class TodayRecord {
            @JSONField(name = "date")
            private String date;
            @JSONField(name = "userStatus")
            private Object userStatus;
            @JSONField(name = "question")
            private Question question;
            @JSONField(name = "lastSubmission")
            private Object lastSubmission;

            @NoArgsConstructor
            @lombok.Data
            public static class Question {
                @JSONField(name = "questionId")
                private String questionId;
                @JSONField(name = "frontendQuestionId")
                private String frontendQuestionId;
                @JSONField(name = "difficulty")
                private String difficulty;
                @JSONField(name = "title")
                private String title;
                @JSONField(name = "titleCn")
                private String titleCn;
                @JSONField(name = "titleSlug")
                private String titleSlug;
                @JSONField(name = "paidOnly")
                private Boolean paidOnly;
                @JSONField(name = "freqBar")
                private Object freqBar;
                @JSONField(name = "isFavor")
                private Boolean isFavor;
                @JSONField(name = "acRate")
                private Double acRate;
                @JSONField(name = "status")
                private Object status;
                @JSONField(name = "solutionNum")
                private Integer solutionNum;
                @JSONField(name = "hasVideoSolution")
                private Boolean hasVideoSolution;
                @JSONField(name = "topicTags")
                private List<TopicTags> topicTags;
                @JSONField(name = "extra")
                private Extra extra;

                @NoArgsConstructor
                @lombok.Data
                public static class Extra {
                    @JSONField(name = "topCompanyTags")
                    private List<TopCompanyTags> topCompanyTags;

                    @NoArgsConstructor
                    @lombok.Data
                    public static class TopCompanyTags {
                        @JSONField(name = "imgUrl")
                        private String imgUrl;
                        @JSONField(name = "slug")
                        private String slug;
                        @JSONField(name = "numSubscribed")
                        private Integer numSubscribed;
                    }
                }

                @NoArgsConstructor
                @lombok.Data
                public static class TopicTags {
                    @JSONField(name = "name")
                    private String name;
                    @JSONField(name = "nameTranslated")
                    private String nameTranslated;
                    @JSONField(name = "id")
                    private String id;
                }
            }
        }
    }
}
