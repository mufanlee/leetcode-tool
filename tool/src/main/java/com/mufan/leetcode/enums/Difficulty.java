package com.mufan.leetcode.enums;

import cn.hutool.core.text.CharSequenceUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

/**
 * Difficulty
 *
 * @author lipeng
 */

@Getter
@AllArgsConstructor
public enum Difficulty {
    /**
     * Easy
     */
    EASY("easy", "Easy"),
    /**
     * Medium
     */
    MEDIUM("medium", "Medium"),
    /**
     * Hard
     */
    HARD("hard", "Hard"),
    /**
     * Unknown
     */
    UNKNOWN("unknown", "Unknown");

    private final String name;

    private final String value;

    /**
     * 获取枚举值
     *
     * @param value value
     * @return Difficulty
     */
    public static Difficulty getEnum(String value) {
        return Optional.ofNullable(value)
                .flatMap(val -> Arrays.stream(Difficulty.values())
                        .filter(it -> CharSequenceUtil.equalsIgnoreCase(it.getValue(), val))
                        .findAny())
                .orElse(UNKNOWN);
    }
}
