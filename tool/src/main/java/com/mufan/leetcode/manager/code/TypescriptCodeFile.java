package com.mufan.leetcode.manager.code;

/**
 * Typescript code file
 *
 * @author lipeng
 */
public class TypescriptCodeFile implements CodeFile {
    public static final String SUFFIX = ".ts";

    private static final String DEFAULT_NAME = "solution.ts";

    private final String code;

    public TypescriptCodeFile(String code) {
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
