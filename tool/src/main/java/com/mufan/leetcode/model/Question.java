package com.mufan.leetcode.model;

import cn.hutool.core.text.StrPool;
import com.mufan.leetcode.enums.Difficulty;
import com.mufan.leetcode.util.StrUtils;
import lombok.Data;

import java.util.List;

/**
 * @author lipeng
 */
@Data
public class Question {
    private String questionId;
    private String questionFrontendId;
    private String categoryTitle;
    private String title;
    private String titleSlug;
    private String content;
    private String translatedTitle;
    private String translatedContent;
    private Difficulty difficulty;
    private String similarQuestions;
    private List<CodeSnippet> codeSnippets;
    private List<TopicTag> topicTags;
    private List<String> hints;
    private String sampleTestCase;
    private String exampleTestcases;
    private String jsonExampleTestcases;

    public String getFullCnName() {
        return questionFrontendId + StrPool.DOT + translatedTitle;
    }

    public String getShortCnName() {
        return questionFrontendId + StrUtils.trimBlank(translatedTitle);
    }
}
