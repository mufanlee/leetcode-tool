package com.mufan.leetcode.manager.code;

/**
 * Go code file
 *
 * @author lipeng
 */
public class GoCodeFile implements CodeFile {
    public static final String SUFFIX = ".go";

    private static final String DEFAULT_NAME = "solution.go";

    private final String code;

    public GoCodeFile(String code) {
        this.code = code;
    }

    @Override
    public String getFileName() {
        return DEFAULT_NAME;
    }

    @Override
    public String getCode() {
        return this.code;
    }
}
