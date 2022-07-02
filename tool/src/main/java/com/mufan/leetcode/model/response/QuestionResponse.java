package com.mufan.leetcode.model.response;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Question Response
 *
 * @author lipeng
 */
@NoArgsConstructor
@Data
public class QuestionResponse {

    @JSONField(name = "data")
    private Data data;

    @NoArgsConstructor
    @lombok.Data
    public static class Data {
        @JSONField(name = "question")
        private Question question;

        @NoArgsConstructor
        @lombok.Data
        public static class Question {
            @JSONField(name = "questionId")
            private String questionId;
            @JSONField(name = "questionFrontendId")
            private String questionFrontendId;
            @JSONField(name = "categoryTitle")
            private String categoryTitle;
            @JSONField(name = "boundTopicId")
            private Integer boundTopicId;
            @JSONField(name = "title")
            private String title;
            @JSONField(name = "titleSlug")
            private String titleSlug;
            @JSONField(name = "content")
            private String content;
            @JSONField(name = "translatedTitle")
            private String translatedTitle;
            @JSONField(name = "translatedContent")
            private String translatedContent;
            @JSONField(name = "isPaidOnly")
            private Boolean isPaidOnly;
            @JSONField(name = "difficulty")
            private String difficulty;
            @JSONField(name = "likes")
            private Integer likes;
            @JSONField(name = "dislikes")
            private Integer dislikes;
            @JSONField(name = "isLiked")
            private Object isLiked;
            @JSONField(name = "similarQuestions")
            private String similarQuestions;
            @JSONField(name = "contributors")
            private List<?> contributors;
            @JSONField(name = "langToValidPlayground")
            private String langToValidPlayground;
            @JSONField(name = "topicTags")
            private List<TopicTag> topicTags;
            @JSONField(name = "companyTagStats")
            private Object companyTagStats;
            @JSONField(name = "codeSnippets")
            private List<CodeSnippet> codeSnippets;
            @JSONField(name = "stats")
            private String stats;
            @JSONField(name = "hints")
            private List<String> hints;
            @JSONField(name = "solution")
            private Object solution;
            @JSONField(name = "status")
            private Object status;
            @JSONField(name = "sampleTestCase")
            private String sampleTestCase;
            @JSONField(name = "metaData")
            private String metaData;
            @JSONField(name = "judgerAvailable")
            private Boolean judgerAvailable;
            @JSONField(name = "judgeType")
            private String judgeType;
            @JSONField(name = "mysqlSchemas")
            private List<?> mysqlSchemas;
            @JSONField(name = "enableRunCode")
            private Boolean enableRunCode;
            @JSONField(name = "envInfo")
            private String envInfo;
            @JSONField(name = "book")
            private Object book;
            @JSONField(name = "isSubscribed")
            private Boolean isSubscribed;
            @JSONField(name = "isDailyQuestion")
            private Boolean isDailyQuestion;
            @JSONField(name = "dailyRecordStatus")
            private Object dailyRecordStatus;
            @JSONField(name = "editorType")
            private String editorType;
            @JSONField(name = "ugcQuestionId")
            private Object ugcQuestionId;
            @JSONField(name = "style")
            private String style;
            @JSONField(name = "exampleTestcases")
            private String exampleTestcases;
            @JSONField(name = "jsonExampleTestcases")
            private String jsonExampleTestcases;
            @JSONField(name = "__typename")
            private String typename;

            @NoArgsConstructor
            @lombok.Data
            public static class TopicTag {
                @JSONField(name = "name")
                private String name;
                @JSONField(name = "slug")
                private String slug;
                @JSONField(name = "translatedName")
                private String translatedName;
                @JSONField(name = "__typename")
                private String typename;
            }

            @NoArgsConstructor
            @lombok.Data
            public static class CodeSnippet {
                @JSONField(name = "lang")
                private String lang;
                @JSONField(name = "langSlug")
                private String langSlug;
                @JSONField(name = "code")
                private String code;
                @JSONField(name = "__typename")
                private String typename;
            }
        }
    }
}
