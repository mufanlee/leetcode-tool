package com.mufan.leetcode.util;

import cn.hutool.setting.dialect.Props;

/**
 * Property Utility Class
 *
 * @author lipeng
 */
public final class PropUtils {
    private PropUtils() {
    }

    public static String getStr(String path, String key) {
        return new Props(path).getStr(key);
    }
}
