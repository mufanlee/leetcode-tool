package com.mufan.leetcode.util;

import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

import java.util.Map;

/**
 * String Template Utility Class
 *
 * @author lipeng
 */
public final class TemplateUtils {
    private TemplateUtils() {
    }

    public static String render(String templatePath, String templateName, String name, Object value) {
        STGroup group = new STGroupFile(templatePath);
        ST st = group.getInstanceOf(templateName);
        st.add(name, value);
        return st.render();
    }

    public static String render(String templatePath, String templateName, Map<String, Object> argMap) {
        STGroup group = new STGroupFile(templatePath);
        ST st = group.getInstanceOf(templateName);
        argMap.forEach(st::add);
        return st.render();
    }
}
