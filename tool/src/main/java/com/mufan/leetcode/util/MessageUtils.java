package com.mufan.leetcode.util;

import java.util.ResourceBundle;

public final class MessageUtils {
    private MessageUtils() {
    }

    public static ResourceBundle getBundle(String baseName) {
        return ResourceBundle.getBundle(baseName);
    }

    public static String getMessage(String baseName, String key) {
        return getBundle(baseName).getString(key);
    }
}
