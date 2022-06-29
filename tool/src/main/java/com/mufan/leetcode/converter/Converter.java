package com.mufan.leetcode.converter;

/**
 * @author lipeng
 */
public interface Converter<S, T> {
  T convert(S source);
}
