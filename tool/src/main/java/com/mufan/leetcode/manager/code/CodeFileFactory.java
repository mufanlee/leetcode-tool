package com.mufan.leetcode.manager.code;

import com.mufan.leetcode.enums.CodeLang;

public interface CodeFileFactory {
    CodeFile getCodeFile(CodeLang lang, String code);
}
