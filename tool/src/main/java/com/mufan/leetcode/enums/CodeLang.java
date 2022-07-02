package com.mufan.leetcode.enums;

import com.mufan.leetcode.manager.code.CodeFileFactory;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

/**
 * Code Lang
 *
 * @author lipeng
 */

@Getter
@AllArgsConstructor
public enum CodeLang {
    /**
     * C++
     */
    CPP("C++", "cpp", "cpp"),
    /**
     * Java
     */
    JAVA("Java", "java", "java"),
    /**
     * Python
     */
    PYTHON3("Python3", "python3", "python"),
    /**
     * Go
     */
    GO("Go", "golang", "go"),
    /**
     * Typescript
     */
    TYPESCRIPT("TypeScript", "typescript", "typescript"),
    /**
     * Unknown
     */
    UNKNOWN("Unknown", "unknown", "unknown");

    private final String name;

    private final String slug;

    private final String value;

    public static CodeLang getEnum(String slug) {
        return Optional.ofNullable(slug)
                .flatMap(val -> Arrays.stream(CodeLang.values())
                        .filter(lang -> lang.getSlug().equals(val))
                        .findFirst())
                .orElse(UNKNOWN);
    }
}
