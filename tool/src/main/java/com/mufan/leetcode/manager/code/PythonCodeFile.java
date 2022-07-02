package com.mufan.leetcode.manager.code;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Python code file
 *
 * @author lipeng
 */
public class PythonCodeFile implements CodeFile {
    public static final String SUFFIX = ".py";

    private static final Pattern PATTERN = Pattern.compile("class (\\w+):[\\s\\S]+");

    private static final String DEFAULT_NAME = "Solution.py";

    private final String code;

    public PythonCodeFile(String code) {
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
