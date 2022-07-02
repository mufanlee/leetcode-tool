package com.mufan.leetcode.manager.code;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * C++ code file
 *
 * @author lipeng
 */
public class CppCodeFile implements CodeFile {
    public static final String SUFFIX = ".cpp";

    private static final Pattern PATTERN = Pattern.compile("class (\\w+) \\{[\\s\\S]+");

    private static final String DEFAULT_NAME = "Solution.cpp";

    private final String code;

    public CppCodeFile(String code) {
        this.code = code;
    }

    @Override
    public String getFileName() {
        Matcher matcher = PATTERN.matcher(code);
        return matcher.find() ? matcher.group(1) + SUFFIX : DEFAULT_NAME;
    }

    @Override
    public String getCode() {
        return this.code;
    }
}
