package com.mufan.leetcode.util;

import com.mufan.leetcode.model.Question;
import org.junit.Assert;
import org.junit.Test;

public class LeetCodeRequestUtilsTest {
  @Test
  public void testGetCnQuestion() {
    Question question = LeetCodeRequestUtils.getCnQuestion("check-if-matrix-is-x-matrix");
    Assert.assertNotNull(question);
  }
}
