package com.mufan.leetcode.helper;

import cn.hutool.core.util.StrUtil;
import com.mufan.leetcode.enums.CodeLang;
import org.junit.Assert;
import org.junit.Test;

public class LeetCodePlaygroundHelperTest {

    @Test
    public void getMainClass() {
        String str = LeetCodePlaygroundHelper.getMainClass("1", CodeLang.JAVA);
        String str2 = LeetCodePlaygroundHelper.getMainClass("1", CodeLang.PYTHON3);
        String str3 = LeetCodePlaygroundHelper.getMainClass("1", CodeLang.GO);
        Assert.assertTrue(StrUtil.isNotBlank(str));
        Assert.assertTrue(StrUtil.isBlank(str2));
        Assert.assertTrue(StrUtil.isBlank(str3));
    }
}