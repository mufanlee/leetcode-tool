package com.mufan.leetcode.converter;

import com.vladsch.flexmark.html2md.converter.FlexmarkHtmlConverter;
import io.github.furstenheim.CopyDown;
import io.github.furstenheim.Options;
import io.github.furstenheim.OptionsBuilder;
import org.apache.commons.lang3.StringUtils;

/**
 * @author lipeng
 */
public final class MdConverter {
  private MdConverter() {}

  // TODO: (1) h`~i~` => hi
  // TODO: (2) `10`^9^
  public static String convert(String html) {
    if (StringUtils.isBlank(html)) {
      return StringUtils.EMPTY;
    }

    return FlexmarkHtmlConverter.builder().build().convert(html);
  }

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