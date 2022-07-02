package com.mufan.leetcode.util;

/**
 * String Utility Class
 *
 * @author lipeng
 */
public final class StrUtils {
    private StrUtils() {
    }

    public static String trimBlank(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (!Character.isSpaceChar(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
