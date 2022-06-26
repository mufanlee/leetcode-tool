package com.mufan.leetcode.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author lipeng
 */
public class FileUtils {

  public static void saveFile(String path, String body) {
    saveFile(new File(path), body);
  }

  public static void saveFile(File file, String body) {
    try {
      if (body == null) {
        return;
      }
      if (!file.getParentFile().exists()) {
        file.getParentFile().mkdirs();
      }
      if (!file.exists()) {
        file.createNewFile();
      }
      FileOutputStream fileOutputStream = new FileOutputStream(file, Boolean.FALSE);
      fileOutputStream.write(body.getBytes("UTF-8"));
      fileOutputStream.close();
    } catch (IOException io) {
      io.printStackTrace();
    }
  }
}
