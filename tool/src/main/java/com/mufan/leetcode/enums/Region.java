package com.mufan.leetcode.enums;

import cn.hutool.core.text.CharSequenceUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

/**
 * Region
 *
 * @author lipeng
 */

@Getter
@AllArgsConstructor
public enum Region {
    /**
     * Local
     */
    LOCAL("local"),
    /**
     * Global
     */
    GLOBAL("global"),
    /**
     * Unknown
     */
    UNKNOWN("unknown");

    private final String value;

    /**
     * 获取枚举值
     *
     * @param value value
     * @return Region
     */
    public static Region getEnum(String value) {
        return Optional.ofNullable(value)
                .flatMap(val -> Arrays.stream(Region.values())
                        .filter(it -> CharSequenceUtil.equalsIgnoreCase(it.getValue(), val))
                        .findAny())
                .orElse(UNKNOWN);
    }
}
