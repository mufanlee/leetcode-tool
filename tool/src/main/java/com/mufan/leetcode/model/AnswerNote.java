package com.mufan.leetcode.model;

import cn.hutool.core.lang.Pair;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author lipeng
 */
@Setter
@Getter
@AllArgsConstructor
public class AnswerNote {
    /**
     * 题号
     */
    private String id;
    /**
     * 题目名称
     */
    private String title;
    /**
     * 题目 Slug
     */
    private String slug;
    /**
     * 难度
     */
    private String difficulty;
    /**
     * 题目内容
     */
    private String question;
    /**
     * 代码内容
     */
    private List<Pair<String, String>> codes;
}
