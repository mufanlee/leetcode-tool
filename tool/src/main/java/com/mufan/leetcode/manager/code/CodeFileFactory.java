package com.mufan.leetcode.manager.code;

import com.mufan.leetcode.enums.CodeLang;

/**
 * Code file factory
 *
 * @author lipeng
 */
public interface CodeFileFactory {
    /**
     * Get Code file
     *
     * @param lang language
     * @param code code string
     * @return CodeFile
     */
    CodeFile getCodeFile(CodeLang lang, String code);
}
