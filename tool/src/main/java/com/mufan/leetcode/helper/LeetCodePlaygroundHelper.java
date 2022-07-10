package com.mufan.leetcode.helper;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.text.UnicodeUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.mufan.leetcode.constant.LeetCodeConstants;
import com.mufan.leetcode.enums.CodeLang;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * LeetCode Playground Helper
 *
 * @author lipeng
 */
public final class LeetCodePlaygroundHelper {
    private static final Pattern PATTERN = Pattern.compile(".*code: '(.+)',");

    private LeetCodePlaygroundHelper() {
    }

    public static String getMainClass(String questionId, CodeLang lang) {
        HttpResponse response = HttpRequest.post(LeetCodeConstants.PLAYGROUND_URL)
                .formStr(MapUtil.builder("question", questionId)
                        .put("lang", lang.getSlug())
                        .build())
                .timeout(LeetCodeConstants.TIMEOUT)
                .execute();
        Matcher matcher = PATTERN.matcher(response.body());
        if (matcher.find()) {
            String str = matcher.group(1);
            return str.contains("MainClass") ? UnicodeUtil.toString(str) : CharSequenceUtil.EMPTY;
        }
        return CharSequenceUtil.EMPTY;
    }
}
