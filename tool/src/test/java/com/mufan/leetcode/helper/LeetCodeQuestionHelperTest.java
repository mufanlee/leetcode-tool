package com.mufan.leetcode.helper;

import cn.hutool.core.lang.Assert;
import com.mufan.leetcode.model.Question;
import org.junit.Test;

import java.util.Optional;

public class LeetCodeQuestionHelperTest {

    @Test
    public void getQuestion() {
        Optional<Question> question = LeetCodeQuestionHelper.getQuestion("check-if-matrix-is-x-matrix");
        Assert.isTrue(question.isPresent());
    }
}