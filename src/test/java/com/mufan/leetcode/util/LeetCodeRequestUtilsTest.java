package com.mufan.leetcode.util;

import com.mufan.leetcode.model.DailyQuestion;
import com.mufan.leetcode.model.Question;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class LeetCodeRequestUtilsTest {
  @Test
  public void testGetCnQuestion() {
    Question question = LeetCodeRequestUtils.getCnQuestion("check-if-matrix-is-x-matrix");
    Assert.assertNotNull(question);
  }

  @Test
  public void getDailyQuestion() {
    Optional<DailyQuestion> question = LeetCodeRequestUtils.getDailyQuestion();
    Assert.assertTrue(question.isPresent());
  }
}
