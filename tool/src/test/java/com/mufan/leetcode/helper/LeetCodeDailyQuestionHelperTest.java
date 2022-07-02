package com.mufan.leetcode.helper;

import com.mufan.leetcode.model.DailyQuestion;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class LeetCodeDailyQuestionHelperTest {

    @Test
    public void getDailyQuestion() {
        Optional<DailyQuestion> dailyQuestion = LeetCodeDailyQuestionHelper.getDailyQuestion();
        Assert.assertTrue(dailyQuestion.isPresent());
    }
}