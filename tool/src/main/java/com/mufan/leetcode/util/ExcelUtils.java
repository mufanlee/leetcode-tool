package com.mufan.leetcode.util;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;

import java.util.List;
import java.util.Map;

/**
 * Excel Utility Class
 *
 * @author lipeng
 */
public final class ExcelUtils {
    private ExcelUtils() {
    }

    public static <T> void write(String path, List<T> data) {
        ExcelWriter writer = ExcelUtil.getWriter(path);
        writer.write(data, true);
        writer.close();
    }

    public static <T> void write(String path, List<T> data, Map<String, String> headerAlias) {
        ExcelWriter writer = ExcelUtil.getWriter(path);
        headerAlias.forEach(writer::addHeaderAlias);
        writer.setOnlyAlias(true);
        writer.write(data, true);
        writer.close();
    }
}
