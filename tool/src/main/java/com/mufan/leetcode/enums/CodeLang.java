package com.mufan.leetcode.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CodeLang {
  CPP("C++", "cpp"),
  JAVA("Java", "java"),
  PYTHON3("Python3", "python3"),
  GO("Go", "go"),
  TYPESCRIPT("TypeScript", "typescript");

  private final String value;

  private final String slug;
}
