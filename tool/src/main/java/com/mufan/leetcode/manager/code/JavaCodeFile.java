package com.mufan.leetcode.manager.code;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Java code file
 *
 * @author lipeng
 */
public class JavaCodeFile implements CodeFile {
    public static final String SUFFIX = ".java";

    private static final Pattern PATTERN = Pattern.compile("[\\s\\S]*class (\\w+) \\{[\\s\\S]+");

    private static final String DEFAULT_NAME = "Solution.java";

    private final String code;


    public JavaCodeFile(String code) {
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
