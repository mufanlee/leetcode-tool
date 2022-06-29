package com.mufan.leetcode.util;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

/**
 * @author lipeng
 */
public final class TemplateUtils {
  private TemplateUtils() {}

  public static <T> String render(String templatePath, String templateName, String name, T value) {
    STGroup group = new STGroupFile(templatePath);
    ST st = group.getInstanceOf(templateName);
    st.add(name, value);
    return st.render();
  }
}
