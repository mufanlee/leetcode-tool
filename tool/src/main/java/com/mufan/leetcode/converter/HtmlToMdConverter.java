package com.mufan.leetcode.converter;

import com.vladsch.flexmark.html2md.converter.FlexmarkHtmlConverter;
import io.github.furstenheim.CopyDown;
import io.github.furstenheim.Options;
import io.github.furstenheim.OptionsBuilder;
import org.apache.commons.lang3.StringUtils;

/**
 * Html To Markdown Converter
 *
 * @author lipeng
 */
public enum HtmlToMdConverter implements Converter<String, String> {
    /**
     * 单例
     */
    INSTANCE;

    public String convert(String html) {
        if (StringUtils.isBlank(html)) {
            return StringUtils.EMPTY;
        }

        return FlexmarkHtmlConverter.builder().build().convert(html);
    }

    /**
     * html to markdown
     * <p>
     * not used
     *
     * @param html html string
     * @return markdown string
     */
    @Deprecated
    public static String toMarkdown(String html) {
        if (StringUtils.isBlank(html)) {
            return StringUtils.EMPTY;
        }

        Options options = OptionsBuilder.anOptions().withBr("-").build();
        CopyDown copyDown = new CopyDown(options);
        return copyDown.convert(html);
    }
}
