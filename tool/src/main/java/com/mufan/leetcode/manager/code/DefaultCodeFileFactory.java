package com.mufan.leetcode.manager.code;

import cn.hutool.core.text.CharSequenceUtil;
import com.mufan.leetcode.enums.CodeLang;

/**
 * Default code file factory
 *
 * @author lipeng
 */
public final class DefaultCodeFileFactory implements CodeFileFactory {
    private static final CodeFileFactory INSTANCE = new DefaultCodeFileFactory();

    private DefaultCodeFileFactory() {
    }

    public static CodeFileFactory getInstance() {
        return INSTANCE;
    }

    @Override
    public CodeFile getCodeFile(CodeLang lang, String code) {
        switch (lang) {
            case CPP:
                return new CppCodeFile(code);
            case JAVA:
                return new JavaCodeFile(code);
            case PYTHON3:
                return new PythonCodeFile(code);
            case GO:
                return new GoCodeFile(code);
            case TYPESCRIPT:
                return new TypescriptCodeFile(code);
            default:
                return new CodeFile() {
                    @Override
                    public String getFileName() {
                        return lang.getName();
                    }

                    @Override
                    public String getCode() {
                        return CharSequenceUtil.EMPTY;
                    }
                };
        }
    }
}
