package com.mufan.leetcode.util;

import cn.hutool.core.io.FileUtil;

/**
 * File Utility Class
 *
 * @author lipeng
 */
public final class FileUtils {
    private FileUtils() {
    }

    public static void saveFile(String path, String content) {
        FileUtil.mkParentDirs(path);
        FileUtil.writeUtf8String(content, path);
    }
}
