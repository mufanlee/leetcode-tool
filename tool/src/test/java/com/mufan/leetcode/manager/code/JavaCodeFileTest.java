package com.mufan.leetcode.manager.code;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class JavaCodeFileTest {

    @Test
    public void getFileName() {
        String code =
                "class Codec {\n"
                        + "\n"
                        + "    // Encodes a URL to a shortened URL.\n"
                        + "    public String encode(String longUrl) {\n"
                        + "        \n"
                        + "    }\n"
                        + "\n"
                        + "    // Decodes a shortened URL to its original URL.\n"
                        + "    public String decode(String shortUrl) {\n"
                        + "        \n"
                        + "    }\n"
                        + "}\n"
                        + "\n"
                        + "// Your Codec object will be instantiated and called as such:\n"
                        + "// Codec codec = new Codec();\n"
                        + "// codec.decode(codec.encode(url));";
        Assert.assertEquals("Codec.java", new JavaCodeFile(code).getFileName());
        String code2 =
                "class Solution {\n"
                        + "    public boolean checkXMatrix(int[][] grid) {\n"
                        + "\n"
                        + "    }\n"
                        + "}";
        Assert.assertEquals("Solution.java", new JavaCodeFile(code2).getFileName());
        String code3 =
                "public class Codec {\n"
                        + "\n"
                        + "    // Encodes a URL to a shortened URL.\n"
                        + "    public String encode(String longUrl) {\n"
                        + "        \n"
                        + "    }\n"
                        + "\n"
                        + "    // Decodes a shortened URL to its original URL.\n"
                        + "    public String decode(String shortUrl) {\n"
                        + "        \n"
                        + "    }\n"
                        + "}\n"
                        + "\n"
                        + "// Your Codec object will be instantiated and called as such:\n"
                        + "// Codec codec = new Codec();\n"
                        + "// codec.decode(codec.encode(url));";
        Assert.assertEquals("Codec.java", new JavaCodeFile(code3).getFileName());
    }
}